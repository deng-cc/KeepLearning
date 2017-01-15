package com.zker.model.product;

import com.zker.model.comment.ProductComment;
import com.zker.model.user.SysUser;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * zker 图友网模拟项目
 * FileName:Product
 * <p>作品的实体VO类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class Product {
    /**
     * 作品的主键ID
     */
    private int productId;

    /**
     * 作品的名称
     */
    private String productName;

    /**
     * 作品的描述
     */
    private String productDesc;

    /**
     * 作品创建的时间
     */
    private Date createDate;

    /**
     * 作品上传的时间
     */
    private Timestamp uploadDate;

    /**
     * 作品修改的时间
     */
    private Timestamp lastModify;

    /**
     * 作品图片的url
     */
    private String imageUrl;

    /**
     * 作品的类别
     */
    private ProductSort productSort;

    /**
     * 作品的用户（作者）
     */
    private SysUser sysUser;

    /**
     * 作品对应的评论
     */
    private Set<ProductComment> productComments = new HashSet<ProductComment>();

    /**
     * 作品对应的查询
     */
    private Set<ProductQuery> productQueries = new HashSet<ProductQuery>();

    //属性的getter和setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Timestamp getLastModify() {
        return lastModify;
    }

    public void setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductSort getProductSort() {
        return productSort;
    }

    public void setProductSort(ProductSort productSort) {
        this.productSort = productSort;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Set<ProductComment> getProductComments() {
        return productComments;
    }

    public void setProductComments(Set<ProductComment> productComments) {
        this.productComments = productComments;
    }

    public Set<ProductQuery> getProductQueries() {
        return productQueries;
    }

    public void setProductQueries(Set<ProductQuery> productQueries) {
        this.productQueries = productQueries;
    }
}
