package com.zker.model.main;

/**
 * zker 图友网模拟项目
 * FileName:SysMain
 * <p>主页滚动Banner的实体VO类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class SysMain {
    /**
     * 主页的主键ID
     */
    private int mainId;

    /**
     * 主页图片的路径
     */
    private String imageUrl;

    /**
     * 主页图片的名称
     */
    private String imageName;

    //属性的getter和setter
    public int getMainId() {
        return mainId;
    }

    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
