package com.zker.dao.job;

import com.zker.model.job.SysJob;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:JobDao
 * <p>职位的持久层操作的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-12 Dulk
 */
public interface JobDao {
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
     * 根据职位名称查找该职位的详细信息
     * @param jobName
     * @return
     */
    SysJob findByName(String jobName);

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

    /**
     * 判断指定的职位是否有用户使用
     *  根据指定的职位的主键ID
     * @param jobId
     * @return
     */
    boolean isHaveUser(int jobId);
}
