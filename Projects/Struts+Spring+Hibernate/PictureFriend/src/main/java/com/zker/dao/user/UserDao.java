package com.zker.dao.user;

import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;

import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:UserDao
 * <p>User用户的持久化操作的接口类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-9 Dulk
 */
public interface UserDao {
    /**
     * 根据登录账号获取用户的详细信息
     * @param pLoginName 登录账号
     * @return 普通用户的对象
     */
    SysUser findUserByLoginName(String pLoginName);

    /**
     * 根据登录账号获取管理员详细信息
     * @param pLoginName 登录的系统管理员账号
     * @return 系统管理员的对象
     */
    SysAdmin findAdminByLoginName(String pLoginName);

    /**
     * 保存用户信息
     * @param sysUser
     * @return
     */
    SysUser save(SysUser sysUser);

    /**
     * 根据用户的主键id获取User用户的信息
     * @param id
     * @return
     */
    SysUser findById(int id);

    /**
     * 根据传入的用户信息，更新用户
     * @param sysUser
     * @return
     */
    SysUser update(SysUser sysUser);

    /**
     * 查找指定页码的用户信息
     * @param page
     * @return
     */
    List<SysUser> findByPage(int page);

    /**
     * 返回用户信息的总数量
     * @return
     */
    int findCount();
}
