package com.zker.service.user;

import com.zker.common.exception.BusinessException;
import com.zker.dao.job.JobDao;
import com.zker.dao.user.UserDao;
import com.zker.model.job.SysJob;
import com.zker.model.login.SysLogin;
import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;
import com.zker.service.login.LoginService;
import org.apache.commons.io.FileUtils;
import org.springframework.dao.DataAccessException;

import java.io.File;
import java.io.IOException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private LoginService loginService;
    private JobDao jobDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public JobDao getJobDao() {
        return jobDao;
    }

    public void setJobDao(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public SysUser register(SysUser user) throws BusinessException{
        //如果和普通账户的某个账户名重名
        SysUser temp1 = userDao.findUserByLoginName(user.getLoginName());
        if (temp1 != null) {
            throw new BusinessException("已经有人注册过" + user.getLoginName() + "的账号");
        }

        //如果和系统管理员账户的某个账户名重名
        SysAdmin temp2 = userDao.findAdminByLoginName(user.getLoginName());
        if (temp2 != null) {
            throw new BusinessException("已经有人注册过" + user.getLoginName() + "的账号");
        }

        //账户不重名，符合注册要求
        try {
            //保存注册信息，并保存登录信息
            SysUser su = userDao.save(user);
            SysLogin sl = new SysLogin();
            sl.setLoginTime(su.getRegisterTime());
            loginService.save(sl, su);
            return su;
        } catch (DataAccessException e) {
            throw new BusinessException();
        }
    }

    /**
     * 根据id主键获取User用户的信息
     * @param id
     * @return
     */
    public SysUser findById(int id) {
        return userDao.findById(id);
    }

    /**
     * 更新用户信息
     * @param sysUser
     * @return
     */
    @Override
    public SysUser updateInfor(SysUser sysUser) {
        try {
            SysJob job = jobDao.findById(sysUser.getSysJob().getJobId());
            SysUser su = userDao.findById(sysUser.getUserId());
            su.setUserName(sysUser.getUserName());
            su.setBirthday(sysUser.getBirthday());
            su.setEmail(sysUser.getEmail());
            su.setIsMale(sysUser.getIsMale());
            su.setPhoneNum(sysUser.getPhoneNum());
            su.setSysJob(job);
            return userDao.update(su);
        } catch (DataAccessException e) {
            throw new BusinessException();
        }
    }

    /**
     * 用户密码更新
     * @param sysUser
     * @return
     */
    @Override
    public SysUser updatePassword(SysUser sysUser) {
        userDao.update(sysUser);
        return sysUser;
    }

    /**
     * 更新用户头像信息
     * @param sysUser
     * @param image
     * @param realPath
     */
    @Override
    public void updateImage(SysUser sysUser, File image, String realPath) {
        String oldImageUrl = null;
        try {
            SysUser temp_user = userDao.findById(sysUser.getUserId());
            if (temp_user.getImageUrl() != null) {
                oldImageUrl = temp_user.getImageUrl();
            }
            temp_user.setImageUrl(sysUser.getImageUrl());
            userDao.update(temp_user);
        } catch (DataAccessException e) {
            throw new BusinessException("出现数据库保存错误，请与系统管理员联系");
        }
        try {
            FileUtils.copyFile(image, new File(realPath + sysUser.getImageUrl()));
            if (oldImageUrl != null) {
                File file = new File(realPath + oldImageUrl);
                //删除文件
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("文件上传错误", e);
        }

    }


}