package wlm.base;

public class BannerBean {
    public String src;
    public String title;

    public BannerBean(String src, String title) {
        this.src = src;
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
