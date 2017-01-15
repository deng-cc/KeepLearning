package com.zker.service.login;

import com.zker.common.exception.BusinessException;
import com.zker.dao.login.LoginDao;
import com.zker.dao.user.UserDao;
import com.zker.model.login.SysLogin;
import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;
import org.springframework.dao.DataAccessException;

/**
 * zker 图友网模拟项目
 * FileName:LoginServiceImpl
 * <p>登录的业务处理实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-10 Dulk
 */
public class LoginServiceImpl implements LoginService {

    /**用户的持久化操作的接口类*/
    private UserDao userDao;

    /**登录的持久化操作的接口类*/
    private LoginDao loginDao;

    //属性的getter和setter
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    /**
     * 根据登录账号获取用户详细信息
     * @param pLoginName 登录账号
     * @return
     */
    @Override
    public SysUser findUserByLoginName(String pLoginName) {
        try {
            return userDao.findUserByLoginName(pLoginName);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BusinessException("出现系统错误，请与管理员联系", e);
        }
    }

    /**
     * 根据登录账号获取系统管理员的详细信息
     * @param pLoginName 登录账号
     * @return
     */
    @Override
    public SysAdmin findAdminByLoginName(String pLoginName) {
        try {
            return userDao.findAdminByLoginName(pLoginName);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BusinessException("出现系统错误，请与管理员联系", e);
        }
    }

    /**
     * 保存登录信息
     * @param pSysLogin
     * @param pSysUser
     * @return
     */
    @Override
    public SysLogin save(SysLogin pSysLogin, SysUser pSysUser) {
        try {
            return loginDao.save(pSysLogin, pSysUser);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BusinessException("出现系统错误，请与管理员联系", e);
        }
    }
}
