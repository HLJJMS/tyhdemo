package wlm.tyhkj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.voice)
    TextView voice;
    @InjectView(R.id.handler)
    TextView handler;
    @InjectView(R.id.UCBrowser)
    TextView UCBrowser;
    @InjectView(R.id.QQBrowser)
    TextView QQBrowser;
    @InjectView(R.id.webview)
    TextView webview;
    @InjectView(R.id.photo)
    TextView photo;
    @InjectView(R.id.upload)
    TextView upload;
    @InjectView(R.id.okhttp)
    TextView okhttp;
    @InjectView(R.id.Notification)
    TextView Notification;
    @InjectView(R.id.viewpager)
    TextView viewpager;
    @InjectView(R.id.recyclerView)
    TextView recyclerView;
    @InjectView(R.id.nv)
    TextView nv;
    @InjectView(R.id.map)
    TextView map;
    private Boolean isEnd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5b83a52b");
    }

    /**
     * 初始化语音识别
     */
    public void initSpeech(final Context context) {
        //1.创建RecognizerDialog对象
        RecognizerDialog mDialog = new RecognizerDialog(context, null);
        //2.设置accent、language等参数
//        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
        mDialog.setParameter(SpeechConstant.ORI_LANG, "cn");
        mDialog.setParameter(SpeechConstant.TRANS_LANG, "en");

        //3.设置回调接口
        mDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                if (!isLast) {
                    //解析语音
                    String result = parseVoice(recognizerResult.getResultString());
                    voice.setText(result);
                }
            }
            @Override
            public void onError(SpeechError speechError) {
            }
        });
        //4.显示dialog，接收语音输入
        mDialog.show();
    }

    /**
     * 解析语音json
     */
    public String parseVoice(String resultString) {
        Gson gson = new Gson();
        Voice voiceBean = gson.fromJson(resultString, Voice.class);

        StringBuffer sb = new StringBuffer();
        ArrayList<Voice.WSBean> ws = voiceBean.ws;
        for (Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }
    @OnClick({R.id.recyclerView, R.id.voice, R.id.nv, R.id.map, R.id.handler, R.id.UCBrowser, R.id.QQBrowser, R.id.webview, R.id.photo, R.id.upload, R.id.okhttp, R.id.Notification, R.id.viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recyclerView:
                Intent intentRecyclerView = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intentRecyclerView);
                break;
            case R.id.voice:
                initSpeech(MainActivity.this);
                break;
            case R.id.nv:
                Intent intentDn = new Intent(MainActivity.this, DnActivity.class);
                startActivity(intentDn);
                break;
            case R.id.map:
                Intent intentMap = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intentMap);
                break;
            case R.id.handler:
                Intent intentHandler = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intentHandler);
                break;
            case R.id.UCBrowser:
                Intent intentUC = new Intent();
                intentUC.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://erp.iwenxin.net/Lecture/LectureUpLoad/1.鉴赏赏析 (Web)/index.html");
                intentUC.setData(content_url);
//        intent.setClassName("com.uc.browser", "com.uc.browser.ActivityUpdate");
                startActivity(intentUC);
                break;
            case R.id.QQBrowser:
                Intent intentUCQQ = new Intent(MainActivity.this, QQBrowserActivity.class);
                startActivity(intentUCQQ);
                break;
            case R.id.webview:
                break;
            case R.id.photo:
                Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
                startActivity(intent);
                break;
            case R.id.upload:
                Intent intentFileUpLoad = new Intent(MainActivity.this, FileUpLoadActivity.class);
                startActivity(intentFileUpLoad);
                break;
            case R.id.okhttp:
                Intent intentOkHttp = new Intent(MainActivity.this, OkHttpActivity.class);
                startActivity(intentOkHttp);
                break;
            case R.id.Notification:
                Intent intentNotification = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intentNotification);
                break;
            case R.id.viewpager:
                Intent intentViewPager = new Intent(MainActivity.this, ViewPageActivity.class);
                startActivity(intentViewPager);
                break;
        }
    }


    /**
     * 语音对象封装
     */
    public class Voice {

        public ArrayList<WSBean> ws;

        public class WSBean {
            public ArrayList<CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }

    //点击两次退出
    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isEnd = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (isEnd == true) {
            finish();
            System.exit(0);
        } else {
            isEnd = true;
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
            h.sendEmptyMessageDelayed(1, 2000);
        }
    }
}
