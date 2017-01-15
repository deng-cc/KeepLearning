package com.zker.model.product;

import com.zker.model.user.SysUser;

import java.sql.Timestamp;

/**
 * zker 图友网模拟项目
 * FileName:ProductQuery
 * <p>作品的查阅表</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class ProductQuery {
    /**
     * 作品查阅表的主键ID
     */
    private int ProductQueryId;

    /**
     * 作品的用户
     */
    private SysUser sysUser;

    /**
     * 作品的查阅时间
     */
    private Timestamp queryTime;

    /**
     * 查阅表对应的作品
     */
    private Product product;

    //属性的getter和setter
    public int getProductQueryId() {
        return ProductQueryId;
    }

    public void setProductQueryId(int productQueryId) {
        ProductQueryId = productQueryId;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Timestamp getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Timestamp queryTime) {
        this.queryTime = queryTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
