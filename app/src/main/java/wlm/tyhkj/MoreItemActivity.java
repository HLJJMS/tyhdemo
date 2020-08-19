package wlm.tyhkj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.BindView;
import wlm.adapter.MoreItemAdapter;
import wlm.bean.MoreItemBean;

public class MoreItemActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<MoreItemBean> list = new ArrayList<>();
    MoreItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_item);
        ButterKnife.bind(this);
        list.add(new MoreItemBean(0, "第一"));
        list.add(new MoreItemBean(1, "第2"));
        list.add(new MoreItemBean(1, "第3"));
        list.add(new MoreItemBean(0, "第4"));
        list.add(new MoreItemBean(1, "第5"));
        list.add(new MoreItemBean(0, "第6"));
        list.add(new MoreItemBean(1, "第7"));
        list.add(new MoreItemBean(0, "第8"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MoreItemAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
