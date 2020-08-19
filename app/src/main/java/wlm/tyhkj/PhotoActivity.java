package wlm.tyhkj;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import butterknife.ButterKnife;
import butterknife.BindView;
import wlm.diyview.GlideCircleWithBorder;

public class PhotoActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    TextView webview;
    @BindView(R.id.photo_base)
    ImageView photoBase;
    @BindView(R.id.photo_gif)
    ImageView photoGif;
    @BindView(R.id.photo_round)
    ImageView photoRound;
    private String gif = "http://www.ghost64.com/qqtupian/zixunImg/local/2017/04/14/14921486513726.gif";
    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1537155629&di=3683860420fb9cbd0b9e7f921983ae40&imgtype=jpg&er=1&src=http%3A%2F%2Fpic21.nipic.com%2F20120511%2F5989071_175938732319_2.jpg";
    private String url2 = "https://www.w3cschool.cn/statics/images/w3c/tools-logo.png";

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        photo();
        roundPhoto();
    }

    private void photo() {
        RequestOptions requestOptions = new RequestOptions().error(R.drawable.ic_menu_camera).placeholder(R.drawable.car).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).override(200, 200);
        Glide.with(this).load(url).apply(requestOptions).into(photoBase);
        RequestOptions gifForOptions = new RequestOptions().override(200, 200).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(this).load(gif).apply(gifForOptions).into(photoGif);
    }


    private void roundPhoto() {
        Glide.with(this).load(url2)
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .transform(new GlideCircleWithBorder(this, 3, Color.parseColor("#ff0000"),Color.parseColor("#ffff00"))))
                .into(photoRound);

    }


}
