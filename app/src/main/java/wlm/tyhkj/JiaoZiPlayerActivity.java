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
        jz_video.setUp("https://www.w3school.com.cn//i/movie.ogg"
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
