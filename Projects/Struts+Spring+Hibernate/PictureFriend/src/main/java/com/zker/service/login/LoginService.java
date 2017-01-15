package com.zker.service.login;

import com.zker.model.login.SysLogin;
import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;

/**
 * zker 图友网模拟项目
 * FileName:LoginService
 * <p>登录的业务处理的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-10 Dulk
 */
public interface LoginService {
    /**
     * 根据登录账号获取用户详细信息
     * @param pLoginName 登录账号
     * @return
     */
    SysUser findUserByLoginName(String pLoginName);

    /**
     * 根据登录账号获取系统管理员的详细信息
     * @param pLoginName 登录账号
     * @return
     */
    SysAdmin findAdminByLoginName(String pLoginName);


    /**
     * 保存登录信息
     * @param pSysLogin
     * @param pSysUser
     * @return
     */
    SysLogin save(SysLogin pSysLogin, SysUser pSysUser);
}
