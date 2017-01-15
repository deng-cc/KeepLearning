package com.zker.dao.product;

import com.zker.model.product.ProductSort;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:ProductSortDao
 * <p>作品类的持久化操作的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-9 Dulk
 */
public interface ProductSortDao {
    /**
     * 获取全部的作品类别
     * @return 作品类别的List集合
     */
    List<ProductSort> findAll();
}
