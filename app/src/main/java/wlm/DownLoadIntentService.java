package wlm;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wlm.base.retrofit.InterfaceForRetrofit;
import wlm.tyhkj.R;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DownLoadIntentService extends IntentService {
    retrofit2.Retrofit retrofit;
    InterfaceForRetrofit service;
    String testName = "name.jpeg";
    File file;
    String url = "http://bos.pgzs.com/wscdn/assistant/wyx/pc/91assistant_pc_v6_1_201904121018111.exe";
    Notification.Builder mProgressBuilder;
    static NotificationManager mNotificationManager;
    boolean isFristTime = true;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DownLoadIntentService(String name) {
        super(name);
    }

    public DownLoadIntentService() {
        super("DownLoadIntentService");

    }
    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://www.xxx.com")
                //通过线程池获取一个线程，指定callback在子线程中运行。
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .build();
        service = retrofit.create(InterfaceForRetrofit.class);
        testName = url.substring(url.lastIndexOf("/")).split("/")[1];//不带"/"
        Log.e("文件名称", testName);
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + testName);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (isFristTime == true){
            isFristTime = false;

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

                    writeFileFromIS(file, response.body().byteStream(), response.body().contentLength());

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e("异常", String.valueOf(t));
                }
            });

        }










    }


    private static int sBufferSize = 8192;

    //将输入流写入文件
    private void writeFileFromIS(File file, InputStream is, long totalLength) {
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mProgressBuilder  = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setProgress((int) totalLength, 0, false)
                .setContentTitle("进度条通知")
                .setContentText("这是一条进度条通知");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotificationManager.notify(1,mProgressBuilder.build());
        }
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
                mProgressBuilder.setProgress((int) totalLength, (int) currentLength, false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mNotificationManager.notify(1,mProgressBuilder.build());
                }
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("我结束了","我结束了");
    }
}
