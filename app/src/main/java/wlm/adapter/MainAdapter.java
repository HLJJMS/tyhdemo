package wlm.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wlm.bean.MainBean;
import wlm.tyhkj.R;

public class MainAdapter extends BaseQuickAdapter<MainBean , BaseViewHolder> {
    public MainAdapter(int layoutResId, @Nullable List<MainBean> data) {
        super(layoutResId, data);
    }

    public MainAdapter(@Nullable List<MainBean> data) {
        super(data);
    }

    public MainAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBean item) {
        helper.setText( R.id.txt,item.getTxt());

    }
}
