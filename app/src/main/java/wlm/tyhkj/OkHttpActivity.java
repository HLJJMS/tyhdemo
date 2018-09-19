package wlm.tyhkj;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    @InjectView(R.id.hundle)
    TextView hundle;
    private String url = "http://tst.zhongqizhiyun.com:8020/api/WXOnlineAppApi/A001GetPersonalInf?UserCode=CN000054";
    private Task task = new Task();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.hundle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hundle:
                okhttpForHundle();
                break;

        }
    }
    private void okhttpForHundle(){
      Thread thread = new Thread(task);
      thread.start();
    }

 class Task implements Runnable {
        String ok;
        @Override
        public void run() {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                ok = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject j = JSON.parseObject(ok);
            String message = j.getString("message");
            Message msg = new Message();
            msg.what = 1;
            msg.obj=message;
            handler.sendMessage(msg);
        }
    };
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                hundle.setText(msg.toString());
            }
        }
    };
}
