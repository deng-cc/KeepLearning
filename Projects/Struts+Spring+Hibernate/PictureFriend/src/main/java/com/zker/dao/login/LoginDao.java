package com.zker.dao.login;

import com.zker.model.login.SysLogin;
import com.zker.model.user.SysUser;

/**
 * zker 图友网模拟项目
 * FileName:LoginDao
 * <p>定义登录的持久化操作的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-9 Dulk
 */
public interface LoginDao {
    /**
     * 保存登录信息
     * @param pSysLogin 登录的信息
     * @param pSysUser 登录账户对应的用户
     * @return 登录信息
     */
    SysLogin save(SysLogin pSysLogin, SysUser pSysUser);
}
