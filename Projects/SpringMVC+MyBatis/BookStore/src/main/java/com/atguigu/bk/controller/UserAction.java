package com.atguigu.bk.controller;

import com.atguigu.bk.biz.UserBiz;
import com.atguigu.bk.entity.TUser;
import com.atguigu.bk.exception.InputNullExcepiton;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    @RequestMapping(value = "/logout")
    //hint: 通过方法参数，直接注入HttpSession
    public String logout(HttpSession session) {
        session.invalidate();
        //hint: 转发重定向，使用redirect前缀
        return "redirect:/book/main.do";
    }

    //hint: doGet方法（和doPost方法分离）
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "/main/login.jsp";
    }


    //hint: doPost方法
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(String uname, String pwd, HttpServletRequest request) {
        String result = null;

        if (uname != null && pwd != null && !uname.equals("") && !pwd.equals("")) {
            UserBiz biz = new UserBiz();
            try {
                TUser user = biz.login(uname, pwd);
                if (user != null) {
                    //用户登录成功了
                    //todo 此处为何不实用model？model和request、session有何区别？
                    request.getSession().setAttribute("user", user);
                    //hint: 想使用请求转发，如对于action跳转到action，就采用forward
                    result = "forward:/book/main.do";
                } else {
                    request.setAttribute("msg", "用户名、或密码错误，请检查");
                    result = "/main/login.jsp";
                }
            } catch (InputNullExcepiton e) {
                request.setAttribute("msg", e.getMessage());
                result = "/main/login.jsp";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "网络异常，请和管理员联系");
                result = "/error.jsp";
            }
        } else {
            request.setAttribute("msg", "用户名或密码，不能为空");
            result = "/main/login.jsp";
        }

        return result;
    }
}
