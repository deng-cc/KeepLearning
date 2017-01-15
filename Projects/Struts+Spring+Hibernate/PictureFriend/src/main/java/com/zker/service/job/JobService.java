package com.zker.service.job;

import com.zker.model.job.SysJob;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:JobService
 * <p>职位业务层的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-12 Dulk
 */
public interface JobService {
    /**
     * 查找所有的职位列表
     * @return
     */
    List<SysJob> findAll();

    /**
     * 保存职位信息
     * @param pSysJob
     * @return
     */
    SysJob save(SysJob pSysJob);

    /**
     * 查找指定的职位
     *  根据职位的主键ID
     * @param id
     * @return
     */
    SysJob findById(int id);

    /**
     * 更新职位的信息
     * @param sysJob
     * @return
     */
    SysJob update(SysJob sysJob);

    /**
     * 删除指定的职位
     * @param sysJob
     */
    void delete(SysJob sysJob);
}
