package wlm.tyhkj;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class QQBrowserActivity extends AppCompatActivity {

    @InjectView(R.id.forum_context)
    WebView forumContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqbrowser);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        forumContext.setDrawingCacheEnabled(true);
        //初始化X5内核
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。

            }

            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("@@", "加载内核是否成功:" + b);

            }
        });
        url();
    }
    private void url(){
        WebSettings webSettings = forumContext.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true); // 关键点
        forumContext.loadUrl("http://erp.iwenxin.net/Lecture/LectureUpLoad/1.鉴赏赏析 (Web)/index.html");
        forumContext.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                forumContext.loadUrl(s);
                return false;
            }
        });

    }
}
