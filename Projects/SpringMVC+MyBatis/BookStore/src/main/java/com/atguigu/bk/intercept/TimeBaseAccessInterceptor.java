package com.atguigu.bk.intercept;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * zker 图友网模拟项目
 * FileName:限时访问的拦截器
 * <p></p>
 * @author Dulk
 * @version 1.00 16-12-30 Dulk
 */
public class TimeBaseAccessInterceptor extends HandlerInterceptorAdapter {
    /**开放时间*/
    private int openingTime;

    /**关闭时间*/
    private int closingTIme;

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTIme(int closingTIme) {
        this.closingTIme = closingTIme;
    }

    /**
     * 处理之前的拦截，要求访问时间在规定的开发时间和关闭时间之间
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (openingTime <= hour && hour < closingTIme) {
            return true;
        } else {
            response.sendRedirect("http://localhost:8080/outsideOfficeHours.html");
            return false;
        }
    }


}
