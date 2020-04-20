package wlm.adapter;

import android.content.Context;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

import wlm.bean.MainBean;
import wlm.tyhkj.R;

public class MainAdapter extends BaseQuickAdapter<MainBean , BaseViewHolder> {
    Reference<Context> contextReference ;
    public MainAdapter(int layoutResId, @Nullable List<MainBean> data , Context context) {
        super(layoutResId, data);
        contextReference = new WeakReference<>(context);
    }

    public MainAdapter(@Nullable List<MainBean> data) {
        super(data);
    }

    public MainAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBean item) {
        helper.setText( R.id.txt,item.getTxt()).addOnClickListener(R.id.txt);

    }
}
