package wlm.tyhkj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import wlm.adapter.ZqzyAdapter;
import wlm.adapter.ZqzyBean;

public class ZqzyListActivity extends AppCompatActivity {
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<ZqzyBean> list = new ArrayList<>();
    ZqzyAdapter adapter = new ZqzyAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zqzy_list);
        ButterKnife.inject(this);
        intdata();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
       adapter.del(new ZqzyAdapter.RemoveItem() {
           @Override
           public void Del(int i) {
               list.remove(0);
               adapter.delData(list);
           }
       });
    }

    private void intdata() {
        list.add(new ZqzyBean(true, "皮长山：", "萨克来得及阿斯利康建档立卡手机端来看"));
        list.add(new ZqzyBean(false, "张亮：", "哈哈哈哈哈哈哈哈哈哈或或或或或或或"));
        list.add(new ZqzyBean(false, "杨国福：", "呀呀呀呀呀呀晕晕晕晕晕晕晕晕晕晕晕晕"));
        list.add(new ZqzyBean(true, "杨振东：", "噢噢噢噢哦哦哦哦哦哦哦哦哦"));
        list.add(new ZqzyBean(false, "网常规：", " 啦啦啦啦啦啦啦啦绿绿"));
        list.add(new ZqzyBean(false, "网常规：", " 啦啦啦啦啦啦啦啦绿绿"));
        list.add(new ZqzyBean(false, "上栗:", "斤斤计较军军军军军军军军"));
        list.add(new ZqzyBean(true, "阿萨德:", " 么么么么么么么木木木木木木木"));
        list.add(new ZqzyBean(true, "的长处:", "男男女女女女女女女女女"));
        list.add(new ZqzyBean(false, "让人山:", "不不不不不不不不不不不不不不不不不"));
        list.add(new ZqzyBean(true, "哈哈哈哈:", "包包包包包包包包包包包包包包包包包包包包包包"));
        list.add(new ZqzyBean(true, "啦啦啦啦:", "凄凄切切群群群群群群群群群群群群"));
        list.add(new ZqzyBean(false, "啛啛喳喳:", "呜呜呜呜呜呜呜呜无无无无无无无无无无"));
        list.add(new ZqzyBean(true, "112323:", "呃呃呃呃呃呃呃呃呃呃呃呃鹅鹅鹅鹅鹅鹅饿"));
        list.add(new ZqzyBean(false, "皮长山:", "柔柔弱弱若若若若若若若若若若若若若若若若若"));
    }
}
