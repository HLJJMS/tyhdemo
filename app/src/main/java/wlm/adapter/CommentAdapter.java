package wlm.adapter;


import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;

import java.util.List;

import wlm.tyhkj.R;


public class CommentAdapter extends BaseQuickAdapter<CommentBean, BaseViewHolder> {
    protected static final int SECTION_HEADER_VIEW = 0x00000444;
    protected int mSectionHeadResId;
//    布局集合
    private SparseIntArray layouts;

    private static final int DEFAULT_VIEW_TYPE = -0xff;
    public static final int TYPE_NOT_FOUND = -404;


    public CommentAdapter(@Nullable List<CommentBean> data) {
        super(data);
        addItemType(0, R.layout.item_yinduo);
        addItemType(1, R.layout.item_yinduo_2);
    }

//    获取布局标记
    @Override
    protected int getDefItemViewType(int position) {
        if (mData.get(position) != null) {
            return mData.get(position).getIs();
        }
        return DEFAULT_VIEW_TYPE;
    }

//    创建布局 如果使用它规定的头在这里处理
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getLayoutId(viewType));
    }

//    获取id

    private int getLayoutId(int viewType) {
        return layouts.get(viewType, TYPE_NOT_FOUND);
    }

    protected void addItemType(int type, @LayoutRes int layoutResId) {
        if (layouts == null) {
            layouts = new SparseIntArray();
        }
        layouts.put(type, layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentBean item) {
        if (item.getIs() == 0) {
            helper.setText(R.id.name, item.getName());
            if (helper.getLayoutPosition()==0){
                helper.setVisible(R.id.line,false);
            }else{
                helper.setVisible(R.id.line,true);
            }
        } else {
            helper.setText(R.id.name, item.getName());

        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(helper.getLayoutPosition());
            }
        });
    }


    @Override
    public void remove(@IntRange(from = 0L) int position) {
        if (mData == null || position < 0
                || position >= mData.size()){
            return;
        }

        CommentBean entity = mData.get(position);

        if (entity.getIs() == 0) {
            for (int i = position + 1; i < mData.size(); i++) {
                if (mData.get(i).getIs() == 1) {
                    super.remove(i);
                    i--;
                } else {
                    break;
                }
            }
        }
        removeDataFromParent(entity);
        super.remove(position);
    }
    /**
     * 移除子控件时，移除父控件实体类中相关子控件数据，避免关闭后再次展开数据重现
     *
     * @param child 子控件实体
     */
    protected void removeDataFromParent(CommentBean child) {
        int position = getParentPosition(child);
        if (position >= 0) {
            IExpandable parent = (IExpandable) mData.get(position);
            parent.getSubItems().remove(child);
        }
    }

}
