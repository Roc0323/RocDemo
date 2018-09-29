package cn.roc.rocdemo.bean;

/**
 * Created by Administrator on 2018/9/29.
 */

public class ListCountDownBean {
    private String name;
    private int hour;
    private int minute;
    private int second;


    public ListCountDownBean() {
    }

    public ListCountDownBean(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
