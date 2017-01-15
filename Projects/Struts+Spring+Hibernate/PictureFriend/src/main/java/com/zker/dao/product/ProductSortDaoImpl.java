package com.zker.dao.product;

import com.zker.dao.BaseDao;
import com.zker.model.product.ProductSort;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:ProductSortDaoImpl
 * <p>作品持久层的实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-9 Dulk
 */
public class ProductSortDaoImpl extends BaseDao implements ProductSortDao {

    @Override
    public List<ProductSort> findAll() {
        String hql = "from ProductSort";
        return getHibernateTemplate().find(hql);
    }
}
