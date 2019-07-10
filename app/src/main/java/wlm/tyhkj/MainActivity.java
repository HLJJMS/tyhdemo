package wlm.tyhkj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import wlm.adapter.MainAdapter;
import wlm.bean.MainBean;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    MainAdapter adapter;
    List<MainBean> list = new ArrayList<>();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        context = this;
        list.add(new MainBean("RecyclerView老版本", RecyclerViewActivity.class));
        list.add(new MainBean("Android原生侧滑布局", DnActivity.class));
        list.add(new MainBean("百度地图", MapActivity.class));
        list.add(new MainBean("Handler测试", HandlerActivity.class));
        list.add(new MainBean("QQ浏览器内核拉起web", QQBrowserActivity.class));
        list.add(new MainBean("Glide4.6.0", PhotoActivity.class));
        list.add(new MainBean("选择本地文件（uri转url）", FileUpLoadActivity.class));
        list.add(new MainBean("Okhttp使用示例", OkHttpActivity.class));
        list.add(new MainBean("原生通知示例", NotificationActivity.class));
        list.add(new MainBean("viewPager示例", ViewPageActivity.class));
        list.add(new MainBean("图片剪裁", ImageCorpActivity.class));
        list.add(new MainBean("饼图", PieViewActivity.class));
        list.add(new MainBean("SQLITE数据库", SqlActivity.class));
        list.add(new MainBean("REALM数据库", RealmActivity.class));
        list.add(new MainBean("retrofit下载（log打印进度）", DownLoadBigFileActivity.class));
        list.add(new MainBean("饺子视频播放", JiaoZiPlayerActivity.class));

        adapter = new MainAdapter(R.layout.item_main, list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(context,list.get(position).getCls()));
            }
        });
    }
}
