package cn.roc.rocdemo.event;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by Roc on 2017/8/6 0006.
 */

public class NineGongGeEvent {
    public boolean isStatus;
    public int position;
    public ImageView imageView;
    public List<String> urlList;
    public List<String> urlList2;
    public List<ImageView> imageList;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public List<String> getUrlList2() {
        return urlList2;
    }

    public void setUrlList2(List<String> urlList2) {
        this.urlList2 = urlList2;
    }

    public List<ImageView> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageView> imageList) {
        this.imageList = imageList;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}
