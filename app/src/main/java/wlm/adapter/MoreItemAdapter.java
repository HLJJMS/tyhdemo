package wlm.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wlm.bean.MoreItemBean;
import wlm.tyhkj.R;

public class MoreItemAdapter extends BaseMultiItemQuickAdapter<MoreItemBean , BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MoreItemAdapter(List<MoreItemBean> data) {
        super(data);
        addItemType(0, R.layout.item_main);
        addItemType(1, R.layout.item_zqzy_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, MoreItemBean item) {
        switch (item.getItemType()){
            case 0:
                helper.setText(R.id.txt,item.getName());
                break;
            case 1:
                helper.setText(R.id.txtone,item.getName());
                break;
        }
    }
}
