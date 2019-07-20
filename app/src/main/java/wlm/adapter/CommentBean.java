package wlm.adapter;

public class CommentBean {
    int is;
    String name;
    String txt;

    public CommentBean(int is, String name, String txt) {
        this.is = is;
        this.name = name;
        this.txt = txt;
    }

    public int getIs() {
        return is;
    }

    public void setIs(int is) {
        this.is = is;
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
