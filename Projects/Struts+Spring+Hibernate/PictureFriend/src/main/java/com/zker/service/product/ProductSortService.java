package com.zker.service.product;

import com.zker.model.product.ProductSort;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:ProductSortService
 * <p>作品分类的业务处理的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-10 Dulk
 */
public interface ProductSortService {

    /**
     * 获取所有的作品分类
     * @return
     */
    List<ProductSort> findAll();
}
