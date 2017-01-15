package com.zker.model.login;

import com.zker.model.user.SysUser;

import java.sql.Timestamp;

/**
 * zker 图友网模拟项目
 * FileName:SysLogin
 * <p>系统登录信息的VO实体类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class SysLogin {
    /**
     * 登录信息的主键ID
     */
    private int loginId;

    /**
     * 对应的用户的类
     */
    private SysUser sysUser;

    /**
     * 登录的时间
     */
    private Timestamp loginTime;

    //属性的getter和setter
    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }
}
