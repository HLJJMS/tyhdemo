package wlm.tyhkj;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.youth.banner.Banner;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JzvdStd;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import wlm.adapter.MainAdapter;
import wlm.adapter.MyBeannerAdapter;
import wlm.base.BannerBean;
import wlm.bean.MainBean;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    MainAdapter adapter;
    List<MainBean> list = new ArrayList<>();
    Context context;
    @BindView(R.id.banner)
    Banner banner;
    List<String> bannerList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    MyBeannerAdapter beannerAdapter;
    List<BannerBean> bannerBeans = new ArrayList<>();
    StandardGSYVideoPlayer videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        videoPlayer = findViewById(R.id.ad_player);
        String path = "http://mp3.9ku.com/mp3/416/415479.mp3";
        videoPlayer.setUp(path,true,"");
        videoPlayer.startPlayLogic();
        palyMp3();
        aboutBanner();
        aboutRecycler();
        Log.e("设备信息", getDeviceInfo());
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
        list.add(new MainBean("线程池", ThreadPoolExecutorActivity.class));
        list.add(new MainBean("流式布局", FlowLayoutActivity.class));
        list.add(new MainBean("EditTextInput监听器", InputFilterActivity.class));
        list.add(new MainBean("web缓存", WebActivity.class));
        list.add(new MainBean("多ITEM的RecyclerView", MoreItemActivity.class));
        list.add(new MainBean("彩票验证", MoneyActivity.class));
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
        bannerBeans.add(new BannerBean("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=375087272,1081250310&fm=26&gp=0.jpg", "春水共长天一色"));
        bannerBeans.add(new BannerBean("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=12753096,4218245377&fm=26&gp=0.jpg", "夏水共长天一色"));
        bannerBeans.add(new BannerBean("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2509171365,1603162426&fm=26&gp=0.jpg", "秋水共长天一色"));
        bannerBeans.add(new BannerBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2140150566,4154407186&fm=26&gp=0.jpg", "冬水共长天一色"));
        MyBeannerAdapter myBeannerAdapter = new MyBeannerAdapter(bannerBeans, context);
        banner.setAdapter(myBeannerAdapter);
        banner.setIndicator(new CircleIndicator(this));
        banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        banner.setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                BannerConfig.INDICATOR_MARGIN, (int) BannerUtils.dp2px(12)));
        myBeannerAdapter.setOnClickItemListener(new MyBeannerAdapter.OnClickItemListener() {
            @Override
            public void clickItemListener(String url) {
                final Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
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
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private String getDeviceInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("主板： " + Build.BOARD);
        sb.append("\n系统启动程序版本号： " + Build.BOOTLOADER);
        sb.append("\n系统定制商： " + Build.BRAND);
        sb.append("\ncpu指令集： " + Build.CPU_ABI);
        sb.append("\ncpu指令集2 " + Build.CPU_ABI2);
        sb.append("\n设置参数： " + Build.DEVICE);
        sb.append("\n显示屏参数：" + Build.DISPLAY);
        sb.append("\n无线电固件版本：" + Build.getRadioVersion());
        sb.append("\n硬件识别码： " + Build.FINGERPRINT);
        sb.append("\n硬件名称： " + Build.HARDWARE);
        sb.append("\nHOST: " + Build.HOST);
        sb.append("\nBuild.ID);" + Build.ID);
        sb.append("\n硬件制造商： " + Build.MANUFACTURER);
        sb.append("\n版本： " + Build.MODEL);
        sb.append("\n硬件序列号： " + Build.SERIAL);
        sb.append("\n手机制造商： " + Build.PRODUCT);
        sb.append("\n 描述Build的标签： " + Build.TAGS);
        sb.append("\nTIME: " + Build.TIME);
        sb.append("\nbuilder类型" + Build.TYPE);
        sb.append("\nUSER: " + Build.USER);
        return sb.toString();
    }

    private void palyMp3() {
        Uri uri = Uri.parse("http://mp3.9ku.com/mp3/416/415479.mp3");
        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(this, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setVolume(1, 1);//配置音量
        player.setLooping(false);//是否循环
        player.prepareAsync();

    }

}
