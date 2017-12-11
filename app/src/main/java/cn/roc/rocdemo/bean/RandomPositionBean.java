package cn.roc.rocdemo.bean;

/**
 * Created by Roc on 2017/12/7.
 */

public class RandomPositionBean {
    private int random;
    private String imageUrl;

    public RandomPositionBean() {
    }

    public RandomPositionBean(int random, String imageUrl) {
        this.random = random;
        this.imageUrl = imageUrl;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



}
