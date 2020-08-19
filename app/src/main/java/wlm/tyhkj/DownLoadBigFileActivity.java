package wlm.tyhkj;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;

import butterknife.ButterKnife;
import butterknife.BindView;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Streaming;
import wlm.DownLoadIntentService;
import wlm.base.retrofit.InterfaceForRetrofit;
import wlm.base.retrofit.Retrofit;

//文件下载重点在于@Streaming这样的做法是防止一次性写入内存，
//返回的数据处理与普通的请求不同一定要写在支线程里

public class DownLoadBigFileActivity extends AppCompatActivity {
    retrofit2.Retrofit retrofit;
    InterfaceForRetrofit service;
    String testName = "name.jpeg";
    File file;
    Context context;
    RxPermissions rxPermissions;
    String url = "http://bos.pgzs.com/wscdn/assistant/wyx/pc/91assistant_pc_v6_1_201904121018111.exe";
    @BindView(R.id.txt)
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_big_file);
        ButterKnife.bind(this);
        testName = url.substring(url.lastIndexOf("/")).split("/")[1];//不带"/"
        Log.e("文件名称", testName);
        context = this;
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"okookko",Toast.LENGTH_LONG).show();
            }
        });
        retrofit =  new retrofit2.Retrofit.Builder()
                .baseUrl("http://www.xxx.com")
                //通过线程池获取一个线程，指定callback在子线程中运行。
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .build();
       service = retrofit.create(InterfaceForRetrofit.class);



        rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {

                } else {
                    Toast.makeText(context, "无权限", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    void xiaziWenjian() {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Call<ResponseBody> call = service.downLoad(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                writeFileFromIS(file, response.body().byteStream(),response.body().contentLength());

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("异常", String.valueOf(t));
            }
        });
    }



    private static int sBufferSize = 8192;
    //将输入流写入文件
    private static void writeFileFromIS(File file, InputStream is, long totalLength) {

        //创建文件
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        OutputStream os = null;
        long currentLength = 0;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            byte data[] = new byte[sBufferSize];
            int len;
            while ((len = is.read(data, 0, sBufferSize)) != -1) {
                os.write(data, 0, len);
                currentLength += len;
                //计算当前下载进度currentLength
                Log.e("下载进度", String.valueOf(currentLength));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }







   void oldFun( Response<ResponseBody> response){
        ResponseBody body = response.body();
        long totalLength = body.contentLength();
        Log.e("文件大小", String.valueOf(totalLength));
        long writenLength = 0;
        InputStream inputStream = body.byteStream();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int length = 0;
        byte[] data = new byte[10485760];
        while (true) {
            try {
                if (!((length = inputStream.read(data)) != -1)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.write(data, 0, length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            writenLength += length;
            Log.e("下载进度", String.valueOf(writenLength));
//                    txt.setText( String.valueOf(writenLength));

            //在这里进行监听，writenLength就是已写入的字节数，totalLength即文件总大小

        }
    }






}
