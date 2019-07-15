package wlm.adapter;

public class ZqzyBean {
    boolean isComment;
    String name;
    String txt;

    public ZqzyBean(boolean isComment, String name, String txt) {
        this.isComment = isComment;
        this.name = name;
        this.txt = txt;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
