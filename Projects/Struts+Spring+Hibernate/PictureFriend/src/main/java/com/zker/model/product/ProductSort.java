package com.zker.model.product;

import java.util.HashSet;
import java.util.Set;

/**
 * zker 图友网模拟项目
 * FileName:ProductSort
 * <p>作品类别的实体VO类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class ProductSort {
    /**
     * 作品类别的主键ID
     */
    private int sortId;

    /**
     * 作品类别的名称
     */
    private String sortName;

    /**
     * 作品类别的描述
     */
    private String sortDesc;

    /**
     * 作品类别对应的作品
     */
    private Set<Product> products = new HashSet<Product>();

    //属性的getter和setter
    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(String sortDesc) {
        this.sortDesc = sortDesc;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
