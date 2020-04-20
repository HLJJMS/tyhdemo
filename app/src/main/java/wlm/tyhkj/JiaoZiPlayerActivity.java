package wlm.tyhkj;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cn.jzvd.JzvdStd;

public class JiaoZiPlayerActivity extends AppCompatActivity {
    JzvdStd jz_video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiao_zi_player);
        jz_video = findViewById(R.id.jz_video);
        jz_video.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子闭眼睛");

    }

    @Override
    protected void onStart() {
        super.onStart();
        for(int i = 0; i<10; i++){
            int a = i;
            int b = 1;
        }
    }
}
