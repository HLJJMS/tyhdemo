package wlm.tyhkj;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wlm.diyview.DonwTimerView;

public class OkHttpActivity extends AppCompatActivity {
    @BindView(R.id.hundle)
    TextView hundle;
    @BindView(R.id.hundleGoodOk)
    TextView hundleGoodOk;
    @BindView(R.id.post)
    TextView post;
    @BindView(R.id.click)
    DonwTimerView click;
    private Message messageOk;
    private String url = "http://tst.zhongqizhiyun.com:8020/api/WXOnlineAppApi/A001GetPersonalInf?UserCode=CN000054";
    private Task task = new Task();
    private ccc cc = new ccc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);
        click.setTimeTotalAndTimeSpace(120,1000);
    }

    @OnClick({R.id.hundle, R.id.hundleGoodOk,R.id.click})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hundle:
                okhttpForHundle();
                break;
            case R.id.hundleGoodOk:
                okhttpForHundleOk();
                break;
            case R.id.click:
                Toast.makeText(this,"点击陈本公告",Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void okhttpForHundleOk() {
        Handler h = new xxxx();
        messageOk = h.obtainMessage();
        Thread thread = new Thread(cc);
        thread.start();
    }

    @OnClick(R.id.post)
    public void onViewClicked() {
        post();
    }

    private void post() {
        PostOkhttp postOkhttp = new PostOkhttp();
        postOkhttp.execute();
    }


    class xxxx extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            hundleGoodOk.setText(msg.obj.toString());
        }
    }

    private void okhttpForHundle() {
        Thread thread = new Thread(task);
        thread.start();
    }

    class ccc implements Runnable {
        @Override
        public void run() {
            List<String> list = new ArrayList<String>();
            list.add("asdas");
            list.add("126323132");
            messageOk.obj = list;
            messageOk.sendToTarget();
        }
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
            msg.obj = message;
            handler.sendMessage(msg);
        }
    }

    ;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                hundle.setText(msg.toString());
            }
        }
    };

    class PostOkhttp extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String s = "";
            OkHttpClient okHttpClient = new OkHttpClient();
            FormBody formBody = new FormBody.Builder().add("companyid", "10008").build();
            Request request = new Request.Builder().url("https://www.yunerpoa.com/api/publicnumberapi/GetTeacherData?").post(formBody).build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                s = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            post.setText(s);
        }
    }
}
