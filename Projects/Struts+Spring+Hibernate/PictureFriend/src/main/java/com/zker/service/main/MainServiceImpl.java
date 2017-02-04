package com.zker.service.main;

import com.zker.common.exception.BusinessException;
import com.zker.dao.main.MainDao;
import com.zker.model.main.SysMain;
import org.apache.commons.io.FileUtils;
import org.springframework.dao.DataAccessException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainServiceImpl implements MainService{

    /**主页的持久化操作的接口类*/
    private MainDao mainDao;

    //getter and setter -- start
    public MainDao getMainDao() {
        return mainDao;
    }

    public void setMainDao(MainDao mainDao) {
        this.mainDao = mainDao;
    }

    //getter and setter -- end



    /**
     * 查找所有的主页图片信息
     * @return
     */
    @Override
    public List<SysMain> findAllMain() {
        try {
            return mainDao.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BusinessException("出现系统错误，请与管理员联系", e);
        }
    }


    /**
     * 增加主页图片信息
     * @param pSysMain
     * @param pImage
     * @param url
     * @return
     */
    @Override
    public SysMain save(SysMain pSysMain, File pImage, String url) {

        try {
            pSysMain = mainDao.save(pSysMain);
        } catch (DataAccessException e1) {
            throw new BusinessException("出现数据库保存错误，请与系统管理员联系");

        }

        //图片保存到硬盘（文件的流，目标地址）
        try {
            FileUtils.copyFile(pImage, new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("文件上传错误", e);
        }

        return pSysMain;
    }

    /**
     * 删除指定的图片
     * @param sysMain
     */
    @Override
    public void delete(SysMain sysMain) {
        mainDao.delete(sysMain);

    }

}
