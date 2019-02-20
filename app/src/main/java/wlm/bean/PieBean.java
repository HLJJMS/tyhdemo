package wlm.bean;

public class PieBean {

    float number;
    String name;
    int color;

    public PieBean(float number, String name, int color) {
        this.number = number;
        this.name = name;
        this.color = color;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
