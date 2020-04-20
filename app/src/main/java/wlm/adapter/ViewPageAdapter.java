package wlm.adapter;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/27.
 */

public class ViewPageAdapter extends PagerAdapter {
    private List<ImageView> list = new ArrayList<ImageView>();

    public void setData(List<ImageView> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if(container==null){
            Log.e("我是试图组","null");
        }else{
            Log.e("我是试图组","have");
        }
        container.addView(list.get(position));
        Log.e("我是新增",String.valueOf(position));
        return list.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        //该函数用以返回给定对象的位置，给定对象是由 instantiateItem()的返回值。
        //在 ViewPager.dataSetChanged() 中将对该函数的返回值进行判断，以决定是否最终触发 PagerAdapter.instantiateItem() 函数。
        //在 PagerAdapter 中的实现是直接传回 POSITION_UNCHANGED。如果该函数不被重载，则会一直返回 POSITION_UNCHANGED，
        //从而导致 ViewPager.dataSetChanged() 被调用时，认为不必触发 PagerAdapter.instantiateItem()。很多人因为没有重载该函数，而导致调用
        //PagerAdapter.notifyDataSetChanged() 后，什么都没有发生。
        return super.getItemPosition(object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
        Log.e("杀掉的", String.valueOf(position));
    }

}
