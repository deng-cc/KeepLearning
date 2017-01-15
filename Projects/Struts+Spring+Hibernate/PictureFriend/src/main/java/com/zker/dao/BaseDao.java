package com.zker.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * zker 图友网模拟项目
 * FileName:BaseDao
 * <p>所有Dao的基础父类，封装了HibernateTemplate</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class BaseDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
