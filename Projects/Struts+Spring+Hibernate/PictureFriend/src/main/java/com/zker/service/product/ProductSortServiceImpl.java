package com.zker.service.product;

import com.zker.common.exception.BusinessException;
import com.zker.dao.product.ProductSortDao;
import com.zker.model.product.ProductSort;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:ProductSortServiceImpl
 * <p>作品分类的业务处理的实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-10 Dulk
 */
public class ProductSortServiceImpl implements ProductSortService{

    /**作品的持久化操作的接口*/
    private ProductSortDao productSortDao;

    //属性的getter和setter
    public ProductSortDao getProductSortDao() {
        return productSortDao;
    }

    public void setProductSortDao(ProductSortDao productSortDao) {
        this.productSortDao = productSortDao;
    }

    /**
     * 获取所有的作品分类
     * @return
     */
    @Override
    public List<ProductSort> findAll() {
        try {
            return productSortDao.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BusinessException("出现系统错误，请与管理员联系", e);
        }
    }
}
