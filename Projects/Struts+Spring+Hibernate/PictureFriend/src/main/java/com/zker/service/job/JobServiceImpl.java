package com.zker.service.job;

import com.zker.common.exception.BusinessException;
import com.zker.dao.job.JobDao;
import com.zker.model.job.SysJob;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:JobServiceImpl
 * <p>职位业务层的实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-12 Dulk
 */
public class JobServiceImpl implements JobService {

    /**职位的持久化操作接口*/
    JobDao jobDao;

    //getter&setter
    public JobDao getJobDao() {
        return jobDao;
    }

    public void setJobDao(JobDao jobDao) {
        this.jobDao = jobDao;
    }



    /**
     * 查找所有的职位列表
     * @return
     */
    @Override
    public List<SysJob> findAll() {
        try {
            return jobDao.findAll();
        } catch (DataAccessException e) {
            throw new BusinessException();
        }
    }

    /**
     * 保存职位的信息
     *      如果存在同名职位，则抛出异常
     * @param pSysJob
     * @return
     */
    @Override
    public SysJob save(SysJob pSysJob) {
        //try {
            SysJob sysJob = jobDao.findByName(pSysJob.getJobName());
            if (sysJob != null) {
                throw new BusinessException("已经存在" + pSysJob.getJobName() + "的职位名称");
            }
            return jobDao.save(pSysJob);
        //} catch (DataAccessException e) {
        //    throw new BusinessException();
        //}

    }

    /**
     * 查找指定的职位
     *  根据职位的主键ID
     * @param id
     * @return
     */
    @Override
    public SysJob findById(int id) {
        try {
            return jobDao.findById(id);
        } catch (DataAccessException e) {
            throw new BusinessException();
        }
    }

    /**
     * 更新职位的信息
     * @param sysJob
     * @return
     */
    @Override
    public SysJob update(SysJob sysJob) {
        try {
            SysJob temp = jobDao.findByName(sysJob.getJobName());
            //如果数据库中存在重名的情况
            if (temp != null && temp.getJobId() != sysJob.getJobId()) {
                throw new BusinessException("已经存在" + sysJob.getJobName() + "的职位名称");
            }
            //不重名
            return jobDao.update(sysJob);
        } catch (DataAccessException e) {
            throw new BusinessException();
        }


    }

    /**
     * 删除指定的职位
     * @param sysJob
     */
    @Override
    public void delete(SysJob sysJob) {
        try {
            //如果该职位有用户选择使用
            //@tips 这里的判断我们没有使用jobDao.findById(sysJob.getJobId())是否为null来进行条件判断，假如一个职位关联20w数据，这样做就直接爆炸了，所以重写个函数，只取其计数
            if (jobDao.isHaveUser(sysJob.getJobId())) {
                throw new BusinessException("有其他用户使用该职位，无法删除");
            }
            //当前用户没有使用该职位
            jobDao.delete(sysJob);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BusinessException();
        }

        jobDao.delete(sysJob);
    }


}
