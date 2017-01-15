package com.zker.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zker.common.Constant;
import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * zker 图友网模拟项目
 * FileName:BaseAction
 * <p>扩展的Action类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class BaseAction extends ActionSupport implements SessionAware, RequestAware, ApplicationAware {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> session;
    private Map<String, Object> request;
    private Map<String, Object> application;

    //扩展ActionSupport状态，增加业务异常
    public static String BUS_EXCEPTION = "busException";

    public Map<String, Object> getSession() {
        return session;
    }
    public Map<String, Object> getRequest() {
        return request;
    }
    public Map<String, Object> getApplication() {
        return application;
    }
    public void setApplication(Map<String, Object> application) {
        this.application = application;

    }
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 当前登录用户是否是系统管理员
     * @return true 表示是系统管理员
     * @return false 表示不是系统管理员
     */
    public boolean isAdmin() {
        if (session.get(Constant.SESSION_USER) != null && session.get(Constant.SESSION_USER).getClass() == SysAdmin.class) {
            return true;
        }
        return false;
    }

    /**
     * 获取当前的用户
     * @return 当前的用户
     */
    public SysUser getCurUser() {
        if (session.get(Constant.SESSION_USER) != null && session.get(Constant.SESSION_USER).getClass() == SysUser.class) {
            return (SysUser) session.get(Constant.SESSION_USER);
        }
        return null;
    }

    /**
     * 获取当前的日期
     * @return 当前的日期
     */
    public Date getCurDate() {
        return new Date();
    }

    /**
     * 获取当前的时间
     * @return 当前的时间
     */
    public Timestamp getCurTime() {
        return new Timestamp(Calendar.getInstance().getTimeInMillis());
    }

    /**
     * 判断当前访问是否已登录
     * @return true 已登录
     * @return false 未登录
     */
    public boolean isLogin() {
        if (session.get(Constant.SESSION_USER) == null) {
            return false;
        }
        return true;
    }
}
