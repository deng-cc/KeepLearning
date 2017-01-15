package com.zker.model.job;

import com.zker.model.user.SysUser;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * zker 图友网模拟项目
 * FileName:SysJob
 * <p>用户职位的VO实体类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class SysJob {
    /**
     * 职位的主键ID
     */
    private int jobId;

    /**
     * 职位的名称
     */
    private String jobName;

    /**
     * 职位的描述
     */
    private String jobDesc;

    /**
     * 职位的修改时间
     */
    private Timestamp lastModity;

    /**
     * 职位所对应的用户
     */
    private Set<SysUser> sysUsers = new HashSet<SysUser>();

    //属性的getter和setter
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public Timestamp getLastModity() {
        return lastModity;
    }

    public void setLastModity(Timestamp lastModity) {
        this.lastModity = lastModity;
    }

    public Set<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
}
