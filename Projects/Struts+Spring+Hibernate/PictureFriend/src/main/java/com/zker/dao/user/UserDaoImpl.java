package com.zker.dao.user;

import com.zker.dao.BaseDao;
import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:UserDaoImpl
 * <p>用户的持久化操作的实现类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-9 Dulk
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 获取普通用户的信息（用户类）
     * @param pLoginName 登录账号
     * @return 普通用户的对象
     */
    @Override
    public SysUser findUserByLoginName(String pLoginName) {
        String hql = "from SysUser as u where u.loginName = ?";
        List<SysUser> users = getHibernateTemplate().find(hql, pLoginName); //pLoginName对应?
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 获取系统管理员的信息（系统管理员类）
     * @param pLoginName 登录的系统管理员账号
     * @return 系统管理员的对象
     */
    @Override
    public SysAdmin findAdminByLoginName(String pLoginName) {
        String hql = "from SysAdmin as u where u.loginName = ?";
        List<SysAdmin> admins = getHibernateTemplate().find(hql, pLoginName);
        return admins.isEmpty() ? null : admins.get(0);
    }

    /**
     * 保存用户信息
     * @param sysUser
     * @return
     */
    @Override
    public SysUser save(SysUser sysUser) {
        Integer id = (Integer)getHibernateTemplate().save(sysUser);
        sysUser.setUserId(id);
        return sysUser;
    }

    /**
     * 根据用户的主键id获取User的用户基本信息
     * @param id
     * @return
     */
    @Override
    public SysUser findById(int id) {
        return getHibernateTemplate().get(SysUser.class, id);
    }

    /**
     * 根据传入的用户参数，更新用户
     * @param sysUser
     * @return
     */
    @Override
    public SysUser update(SysUser sysUser) {
        getHibernateTemplate().update(sysUser);
        return sysUser;
    }


}
