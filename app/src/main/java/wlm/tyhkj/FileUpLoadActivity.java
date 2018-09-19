package wlm.tyhkj;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import wlm.base.PermissionDynamic;
import wlm.base.UriToFliePath;

public class FileUpLoadActivity extends AppCompatActivity {
    UriToFliePath uriToFliePath = new UriToFliePath();
    @InjectView(R.id.url)
    TextView url;
    @InjectView(R.id.power)
    TextView power;
    Context context;
    PermissionDynamic permissionDynamic = new PermissionDynamic();
    @InjectView(R.id.ok)
    TextView ok;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_up_load);
        ButterKnife.inject(this);
        context = getApplicationContext();
        click();
    }

    private void click() {
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionDynamic.ReadAndWrite(FileUpLoadActivity.this);
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                upLoad();
                permissionDynamic.ReadAndWrite(FileUpLoadActivity.this);
//                UpLoad upLoad = new UpLoad();
//                upLoad.execute();
                UpLoad();
            }
        });
    }

    //okhttp上传文件
    private void UpLoad() {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5000, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(5000, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(5000, TimeUnit.SECONDS)//设置连接超时时间
                .build();
        File file = new File(path);
        RequestBody fileBody = RequestBody.create(MediaType.parse(file.getName()), file);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("abc","a")// multipart/form-data
                .addFormDataPart(file.getName(), file.getName(), fileBody)
                .build();
         Request request = new Request.Builder()
                .url("http://testerp.iwenxin.net/webservice/FineClass/B002015")
                .post(requestBody)
                .build();
        Log.e("来你借接口将控件库精课精课", "http://192.168.0.8:802/LessonPlan/PlanUpLoad");
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("失败", e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("成功", response.body().toString());
            }
        });

    }

    @OnClick(R.id.url)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "选择文件"), 0);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(FileUpLoadActivity.this, "亲，木有文件管理器啊-_-!!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (requestCode == 0) {
            Uri uri = data.getData();
            path = uriToFliePath.getPhotoPathFromContentUri(this, uri);
            url.setText(path);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}

