package wlm.tyhkj;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import per.goweii.cropimageview.CropImageView;

public class ImageCorpActivity extends AppCompatActivity {

    @InjectView(R.id.ok)
    TextView ok;
    @InjectView(R.id.img)
    CropImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_corp);
        ButterKnife.inject(this);

        img.setImageResource(R.drawable.laoniu);


    }

    @OnClick({R.id.ok, R.id.img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok:
                break;
            case R.id.img:
                break;
        }
    }
}
