package cn.roc.rocdemo.bean;

/**
 * Created by Roc on 2017/11/29.
 */

public class MobikeBean {
    private int mId;
    private int mImg;
    private String mName;

    public MobikeBean() {
    }

    public MobikeBean(int mId, int mImg, String mName) {
        this.mId = mId;
        this.mImg = mImg;
        this.mName = mName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
