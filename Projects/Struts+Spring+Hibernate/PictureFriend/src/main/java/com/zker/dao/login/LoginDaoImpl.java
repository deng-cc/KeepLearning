package com.zker.dao.login;

import com.zker.dao.BaseDao;
import com.zker.model.login.SysLogin;
import com.zker.model.user.SysUser;

/**
 * zker 图友网模拟项目
 * FileName:LoginDaoImpl
 * <p>定义登录的持久化操作的实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-9 Dulk
 */
public class LoginDaoImpl extends BaseDao implements LoginDao{

    @Override
    public SysLogin save(SysLogin pSysLogin, SysUser pSysUser) {
        //只设定单向关联关系，避免双向关系要获取当前用户全部登录信息
        pSysLogin.setSysUser(pSysUser);
        int id = (Integer) getHibernateTemplate().save(pSysLogin); //@tips HibernateTemplate.save() 返回值为主键id
        pSysLogin.setLoginId(id);
        return pSysLogin;
    }
}
