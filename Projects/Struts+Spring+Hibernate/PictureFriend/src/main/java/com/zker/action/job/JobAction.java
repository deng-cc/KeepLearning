package com.zker.action.job;

import com.zker.action.BaseAction;
import com.zker.common.exception.BusinessException;
import com.zker.model.job.SysJob;
import com.zker.service.job.JobService;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:JobAction
 * <p>职位的Action</p>
 * 
 * @author Dulk
 * @version 1.00 16-10-12 Dulk
 */
public class JobAction extends BaseAction {
    /**职位，主要用来接收封装JobId*/
    private SysJob sysJob;

    /**职位的业务处理类*/
    private JobService jobService;

    //属性的getter和setter
    public SysJob getSysJob() {
        return sysJob;
    }

    public void setSysJob(SysJob sysJob) {
        this.sysJob = sysJob;
    }

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    /**
     * 查找所有职位
     * @return
     */
    public String findAll() {
        List<SysJob> jobs = jobService.findAll();
        getRequest().put("sysJobs", jobs);
        return "findAll";
    }

    /**
     * 保存职位
     * @return
     */
    public String save() {
        try {
            sysJob.setLastModity(getCurTime());
            jobService.save(sysJob);
            return "find";
        } catch (BusinessException e) {
            //如果职位名重复，抓取异常并存入Request
            getRequest().put("message", e.getMessage());
            return "saveInput";
        }
    }

    /**
     * 查找职位
     * 根据职位的主键ID
     * @return
     */
    public String findById() {
        sysJob = jobService.findById(sysJob.getJobId());
        return "update";
    }

    /**
     * 更新职位信息
     * @return
     */
    public String update() {
        try {
            sysJob.setLastModity(getCurTime());
            jobService.update(sysJob);
        } catch (BusinessException e) {
            getRequest().put("message", e.getMessage());
            return "updateInput";
        }
        return "find";
    }

    /**
     * 删除指定的职位
     * @return
     */
    public String delete() {
        try {
            jobService.delete(sysJob);
        } catch (BusinessException e) {
            getRequest().put("message", e.getMessage());
        }
        return "find";
    }
}
