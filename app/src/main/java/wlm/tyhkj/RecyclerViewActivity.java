package wlm.tyhkj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import wlm.adapter.RecyclerAdapter;

/**
 * Created by wlm on 2018/8/28.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        setList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
    }
    private void setList(){
        list.add("TIEM1");
        list.add("TIEM2");
        list.add("TIEM3");
        list.add("TIEM4");
        list.add("TIEM5");
        list.add("TIEM6");
        list.add("TIEM7");
        list.add("TIEM8");
        list.add("TIEM9");
        list.add("TIEM10");
        list.add("TIEM11");
        list.add("TIEM12");
    }

}