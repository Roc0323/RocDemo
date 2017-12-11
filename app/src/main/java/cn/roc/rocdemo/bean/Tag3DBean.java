package cn.roc.rocdemo.bean;

/**
 * Created by Roc on 2017/12/8.
 */

public class Tag3DBean {
    private int id;
    private int imgUrl;
    private String name;

    public Tag3DBean() {
    }

    public Tag3DBean(int id, int imgUrl, String name) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
