package com.zker.service.main;

import com.zker.model.main.SysMain;

import java.io.File;
import java.util.List;

public interface MainService {

    /**
     * 查找所有的主页图片信息
     * @return
     */
    List<SysMain> findAllMain();

    /**
     * 增加新的主页图片
     * @param sysMain
     * @param image
     * @param url
     * @return
     */
    SysMain save(SysMain sysMain, File image, String url);
}
