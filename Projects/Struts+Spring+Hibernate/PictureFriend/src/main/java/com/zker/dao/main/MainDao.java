package com.zker.dao.main;

import com.zker.model.main.SysMain;

import java.io.File;
import java.util.List;

public interface MainDao {

    /**
     * 查找所有的主页图片信息
     * @return
     */
    List<SysMain> findAll();

    /**
     * 保存主页图片
     * @param sysMain
     * @return
     */
    SysMain save(SysMain sysMain);

    /**
     * 删除指定的图片
     * @param sysMain
     */
    void delete(SysMain sysMain);
}
