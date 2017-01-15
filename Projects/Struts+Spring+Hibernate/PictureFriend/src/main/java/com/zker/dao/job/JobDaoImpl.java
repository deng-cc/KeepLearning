package com.zker.dao.job;

import com.zker.dao.BaseDao;
import com.zker.model.job.SysJob;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:JobDaoImpl
 * <p>职位持久层操作的实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-12 Dulk
 */
public class JobDaoImpl extends BaseDao implements JobDao {

    /**
     * 查找所有的职位列表
     * @return
     */
    @Override
    public List<SysJob> findAll() {
        String hql = "from SysJob";
        return getHibernateTemplate().find(hql);
    }

    /**
     * 保存职位信息
     * @param pSysJob
     * @return
     */
    @Override
    public SysJob save(SysJob pSysJob) {
        int id = (Integer)getHibernateTemplate().save(pSysJob);
        pSysJob.setJobId(id);
        return pSysJob;
    }

    /**
     * 根据职位名称查找该职位的详细信息
     * @param jobName
     * @return
     */
    @Override
    public SysJob findByName(String jobName) {
        String hql = "from SysJob where jobName = ?";
        List<SysJob> jobs = getHibernateTemplate().find(hql, jobName);
        return jobs.isEmpty() ? null : jobs.get(0);
    }

    /**
     * 查找指定的职位
     *  根据职位的主键ID
     * @param id
     * @return
     */
    @Override
    public SysJob findById(int id) {
        return getHibernateTemplate().get(SysJob.class, id);
    }

    /**
     * 更新职位的信息
     * @param sysJob
     * @return
     */
    @Override
    public SysJob update(SysJob sysJob) {
        getHibernateTemplate().update(sysJob);
        return sysJob;

    }

    /**
     * 删除指定的职位
     * @param sysJob
     */
    @Override
    public void delete(SysJob sysJob) {
        getHibernateTemplate().delete(sysJob);
    }

    /**
     * 判断指定的职位是否有用户使用
     *  根据指定的职位的主键ID
     * @param jobId
     * @return
     */
    @Override
    public boolean isHaveUser(int jobId) {
        String hql = "select count(*) from SysUser u where u.sysJob.jobId = " + jobId;
        int count = Integer.valueOf(getHibernateTemplate().find(hql).iterator().next().toString()); //@tips find返回的List，iterator()返回Iterator<E>
        return count > 0; //@tips 不错！精巧！
    }
}
