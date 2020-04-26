package wlm.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MoreItemBean implements MultiItemEntity {
    String name;
    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MoreItemBean(int itemType, String name) {
        this.itemType = itemType;
        this.name = name;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
