package wlm.tyhkj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import wlm.adapter.MainAdapter;
import wlm.base.BannerLoadImage;
import wlm.bean.MainBean;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    MainAdapter adapter;
    List<MainBean> list = new ArrayList<>();
    Context context;
    @InjectView(R.id.banner)
    Banner banner;
    List<String> bannerList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        context = this;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        aboutBanner();
        aboutRecycler();
    }

    private void aboutRecycler() {
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
        list.add(new MainBean("饼图+拖拽小球（吸盘）", PieViewActivity.class));
        list.add(new MainBean("SQLITE数据库", SqlActivity.class));
        list.add(new MainBean("REALM数据库", RealmActivity.class));
        list.add(new MainBean("retrofit下载（log打印进度）", DownLoadBigFileActivity.class));
        list.add(new MainBean("饺子视频播放", JiaoZiPlayerActivity.class));
        list.add(new MainBean("换xml的recycle", ZqzyListActivity.class));
        list.add(new MainBean("换xml的recycle(baserecyclerviewhelper)", CommentActivity.class));
        list.add(new MainBean("Retrofit网络请求和Android原生网络请求", RetrofitAndUrlConnectionActivity.class));
        adapter = new MainAdapter(R.layout.item_main, list, context);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(context, list.get(position).getCls()));
            }
        });
    }


    private void aboutBanner() {
        bannerList.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1562745599&di=7f3906730091a19e20d1281e15e3aadf&src=http://www.qqoi.cn/img_bizhi/245213297.jpeg");
        bannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562755694181&di=9cf7bd721728d9dfc1aa3ae66ce14315&imgtype=0&src=http%3A%2F%2Fimg.tukexw.com%2Fimg%2Fba2d83aaf5371864.jpg");
        bannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562755694181&di=5029f7203a910ab388f3be3a789f9381&imgtype=0&src=http%3A%2F%2Ffile.mumayi.com%2Fforum%2F201503%2F27%2F231530y62twcwttsww2qdk.jpg");
        bannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562755694180&di=51ff7f29c13e93ff5f618ab7cf73d808&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F579181e901c9b.jpg");
        titleList.add("秋水共长天一色");
        titleList.add("长河落日圆");
        titleList.add("千里冰封");
        titleList.add("长白山天池");
        banner.setImageLoader(new BannerLoadImage()).isAutoPlay(true).setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE).setImages(bannerList).setBannerTitles(titleList).start().setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                final Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(bannerList.get(position)));
                if (intent.resolveActivity(getPackageManager()) == null) {
                    Toast.makeText(getApplicationContext(), "没有匹配的程序", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(Intent.createChooser(intent, "请选择浏览器"));
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
