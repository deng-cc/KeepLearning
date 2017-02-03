package com.zker.dao.main;

import com.zker.dao.BaseDao;
import com.zker.model.main.SysMain;

import java.io.File;
import java.util.List;

public class MainDaoImpl extends BaseDao implements MainDao {

    /**
     * 查询所有的主页图片
     * @return
     */
    @Override
    public List<SysMain> findAll() {
        String hql = "from SysMain";
        return getHibernateTemplate().find(hql);
    }

    /**
     * 增加主页图片
     * @param sysMain
     * @return
     */
    @Override
    public SysMain save(SysMain sysMain) {
        Integer id = (Integer) getHibernateTemplate().save(sysMain);
        sysMain.setMainId(id);
        return sysMain;
    }
}
