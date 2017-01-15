package com.zker.service.user;

import com.zker.model.user.SysUser;

import java.io.File;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    SysUser register(SysUser user);

    /**
     * 根据用户主键获取对应User的信息
     * @param id
     * @return
     */
    SysUser findById(int id);

    /**
     * 用户更新
     * @param sysUser
     * @return
     */
    SysUser updateInfor(SysUser sysUser);

    /**
     * 用户密码更新
     * @param sysUser
     * @return
     */
    SysUser updatePassword(SysUser sysUser);

    /**
     * 更新用户头像
     * @param sysUser
     * @param image
     * @param path
     */
    void updateImage(SysUser sysUser, File image, String path);
}
