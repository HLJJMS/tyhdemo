package wlm.tyhkj;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.BindView;
import wlm.adapter.ViewPageAdapter;

public class ViewPageActivity extends AppCompatActivity {

    @BindView(R.id.viewpage)
    ViewPager viewpage;
    @BindView(R.id.point)
    LinearLayout point;
    private ImageView photo1, photo2, photo3, photo4, photo5, pointImg;
    private View view1, view2, view3;
    private List<ImageView> imgList = new ArrayList<ImageView>();
    private List<View> list = new ArrayList<View>();
    private ViewPageAdapter adapter = new ViewPageAdapter();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        ButterKnife.bind(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        viewXml(layoutInflater);
        ImgView();
        AddPoint();
        viewpage.setAdapter(adapter);
        adapter.setData(imgList);
        HandlerFunction();
        ChangeListener();
    }

    private void ChangeListener() {
        viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void AddPoint() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 20);
        params.leftMargin = 10;
        for (int i = 0; i < imgList.size(); i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.shape_point_selector);
            img.setLayoutParams(params);
            point.addView(img);
        }
    }

    private void HandlerFunction() {
        handler.post(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                if (viewpage.getCurrentItem() == imgList.size() - 1) {
                    viewpage.setCurrentItem(0);
                    i = imgList.size() - 1;
                } else {
                    viewpage.setCurrentItem(viewpage.getCurrentItem() + 1);
                    i = viewpage.getCurrentItem() - 1;
                }
                point.getChildAt(i).setSelected(false);
                point.getChildAt(viewpage.getCurrentItem()).setSelected(true);
                handler.postDelayed(this, 1000);
            }
        });
    }

    private void ImgView() {


    }

    private void viewXml(LayoutInflater layoutInflater) {
//        view1 = layoutInflater.inflate(R.layout.viewpager1, null);
//        view2 = layoutInflater.inflate(R.layout.viewpager2, null);
//        view3 = layoutInflater.inflate(R.layout.viewpager3, null);
//        list.add(view1);
//        list.add(view2);
//        list.add(view3);
    }


}
//        viewpage.setOffscreenPageLimit(1);//设置缓存页面数。当前页，左右两边（单边）最大缓存页面数。
//        mViewPager.addOnPageChangeListener(new OnMyPageChangeListener());//页面变化监听
//        mViewPager.setOffscreenPageLimit(2);//设置缓存页面数。当前页，左右两边（单边）最大缓存页面数。
//        mViewPager.setOnScrollChangeListener(new OnMyScrollChangeListener());//滚动状态监听，minSdkVersion：23
//        mViewPager.getCurrentItem();//获取当前显示页索引
//        mViewPager.getOffscreenPageLimit();//获取缓存页面数
//        mViewPager.onSaveInstanceState();
//        mViewPager.setPageTransformer();
//        mMyPagerAdapter.notifyDataSetChanged();//当适配器数据集更改时，调用通知UI更改。PagerAdapter.notifyDataSetChanged() 被触发时，
//         ViewPager.dataSetChanged() 也会被触发。该函数将使用 getItemPosition() 的返回值来进行判断，如果为 POSITION_UNCHANGED，
//         则什么都不做；如果为 POSITION_NONE，则调用 PagerAdapter.destroyItem() 来去掉该对象，
//         并设置为需要刷新 (needPopulate = true) 以便触发 PagerAdapter.instantiateItem() 来生成新的对象。
//        setPageNum(0);//设置显示首页