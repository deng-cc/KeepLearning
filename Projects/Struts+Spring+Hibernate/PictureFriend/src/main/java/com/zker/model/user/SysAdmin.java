package com.zker.model.user;

/**
 * zker 图友网模拟项目
 * FileName:SysAdmin
 * <p>系统管理员的账户实体VO类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class SysAdmin {
    /**
     * 系统管理员的主键ID
     */
    private int adminId;

    /**
     * 系统管理员的登录名
     */
    private String loginName;

    /**
     * 系统管理员的登录密码
     */
    private String Password;

    //属性的getter和setter
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
