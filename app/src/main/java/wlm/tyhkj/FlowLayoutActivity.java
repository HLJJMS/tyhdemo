package wlm.tyhkj;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import wlm.diyview.FlowLayout;

public class FlowLayoutActivity extends AppCompatActivity {
    FlowLayout flowLayout;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
        flowLayout = findViewById(R.id.flow);

        list.add("Android");
        list.add("Java");
        list.add("IOS");
        list.add("python");
        list.add("C");
        list.add("C++");
        list.add("C#");
        list.add("HTML");
        list.add("CSS");
        list.add("白鹭引擎");
        list.add("EGRET");
        list.add("皮长山");
        list.add("戈尔巴乔夫");
        list.add("雨打梨花深闭门，孤负青春，虚负青春465465132465476789761465");
        list.add("春风得意马蹄急，一眼看尽长安花");
        list.add("人生只若如初见，何事秋风悲画扇");
        list.add("此地无银三百两");
        list.add("北京市朝阳区三间房镇，双惠苑3号，韵达");
        list.add("1546698765");


//往容器内添加TextView数据
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowLayout != null) {
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(28, 10, 28, 10);
            tv.setText(list.get(i));
            tv.setSingleLine();
            tv.setBackground(ContextCompat.getDrawable(this, R.drawable.conner_bg));
            tv.setLayoutParams(layoutParams);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),tv.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
            flowLayout.addView(tv, layoutParams);
        }
    }
}
