package wlm.bean;



public class MainBean{
    public MainBean(String txt,   Class<?> cls) {
        this.txt = txt;
        this.cls = cls;
    }

    String txt;
    Class<?> cls;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
}
