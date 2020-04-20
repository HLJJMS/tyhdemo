package wlm.tyhkj;

import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import wlm.bean.PieBean;
import wlm.diyview.PieView;

public class PieViewActivity extends AppCompatActivity {

    @InjectView(R.id.pie_view)
    PieView pieView;
    private List<PieBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_view);
        ButterKnife.inject(this);
        setData();
    }

    private void setData() {
        list.add(new PieBean(0.5f,"狍子", Color.YELLOW));
        list.add(new PieBean(0.2f,"骡子", Color.BLACK));
        list.add(new PieBean(0.3f,"驴", Color.RED));
        pieView.setList(list);
    }
}
