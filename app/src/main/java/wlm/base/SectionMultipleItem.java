package wlm.base;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import wlm.adapter.CommentBean;
import wlm.adapter.ZqzyBean;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionMultipleItem extends SectionMultiEntity<CommentBean> implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    private int itemType;
    private boolean isMore;
    private CommentBean video;

    public SectionMultipleItem(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }

    public SectionMultipleItem(int itemType, CommentBean video) {
        super(video);
        this.video = video;
        this.itemType = itemType;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public CommentBean getVideo() {
        return video;
    }

    public void setVideo(CommentBean video) {
        this.video = video;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
