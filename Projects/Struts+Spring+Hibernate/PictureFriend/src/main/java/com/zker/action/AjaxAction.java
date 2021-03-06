package com.zker.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zker.common.util.Message;
import com.zker.common.util.SpringContextUtils;
import com.zker.dao.user.UserDao;
import org.json.JSONObject;

import java.io.IOException;


public class AjaxAction extends ActionSupport {
    /**用来接受封装的参数 LoginName 用户名*/
    String loginName;

    /**封装信息，为了测试JSON刻意做成简单的类*/
    Message message = new Message();

    /**用来返回用于js接收*/
    String result;

    /**用户的持久化操作类*/
    UserDao userDao;

    //tips 要有getter&setter，否则$post的param参数传递不过来
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 利用Ajax实现注册的用户名重复性校验
     * @return
     */
    public String ajaxRegister() throws IOException {
        //tips 如何手动取出容器中的bean?答案如下
        //UserDao userDao = (UserDao)SpringContextUtils.getContext().getBean("userDao"); //采用非Spring注入时，采用手动取bean
        if (userDao.findAdminByLoginName(loginName) != null
                || userDao.findUserByLoginName(loginName) != null) {
            message.setMsg("用户名已存在");
            message.setStatus(false);
        } else {
            message.setMsg("用户名可以注册");
            message.setStatus(true);
        }

        /*
        //JSON-String转换 obj -> jsonStr
        //当struts-login.xml中root为result时，此处才需要解开
        this.result = JSONObject.wrap(message).toString();
        */

        return "register";
    }
}
