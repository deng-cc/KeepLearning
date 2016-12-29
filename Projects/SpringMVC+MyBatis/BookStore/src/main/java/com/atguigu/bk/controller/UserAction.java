package com.atguigu.bk.controller;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.biz.UserBiz;
import com.atguigu.bk.entity.TBook;
import com.atguigu.bk.entity.TUser;
import com.atguigu.bk.exception.InputNullExcepiton;
import com.atguigu.bk.util.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /**
     * 用户登出
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    //hint: 通过方法参数，直接注入HttpSession
    public String logout(HttpSession session) {
        session.invalidate();
        //hint: 转发重定向，使用redirect前缀
        return "redirect:/book/main.do";
    }

    /**
     * GET请求到达用户登录页面
     * @return
     */
    //hint: doGet方法（和doPost方法分离）
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "/main/login.jsp";
    }


    /**
     * 用户登录
     * @param uname
     * @param pwd
     * @param request
     * @return
     */
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
                    //todo 2 此处为何不实用model？model和request、session有何区别？
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


    /**
     * 添加商品至购物车
     * @param isbn
     * @param request
     * @return
     */
    @RequestMapping("/addShopCar")
    public String addShopCar(@RequestParam("isbn") String isbn, HttpServletRequest request) {
        String result = null;

        if(isbn != null){
            //判断当前用户是否登录
            if(request.getSession().getAttribute("user") != null){
                Object object = request.getSession().getAttribute("ShopCar");
                if(object == null){
                    Map<String,Integer> shopCar = new HashMap<String,Integer>();
                    //将书籍添加到Map中作为购物车书籍添加
                    shopCar.put(isbn, 1);
                    request.getSession().setAttribute("ShopCar",shopCar);
                }else{
                    Map<String,Integer> shopCar = (Map<String,Integer>)object;
                    shopCar.put(isbn, 1);
                }
                //todo 3 此处是否可以不用forward
                result = "forward:/user/showShopCar.do";
            }else {
                //没有登录
                result = "/main/login.jsp";
            }

        }else{
            request.setAttribute("msg", "网络异常，请和管理员联系");
            result = "/error.jsp";
        }

        return result;
    }

    /**
     * 显示购物车信息
     * @return
     */
    @RequestMapping(value = "/showShopCar")
    public String showShopCar(HttpServletRequest request) {
        String result = null;

        if(request.getSession().getAttribute("user") != null){
            Object object = request.getSession().getAttribute("ShopCar");
            if(object != null){
                //取出Session中的购物车
                //todo 4 购物车存在于Session中，未进行持久化，那么，退出后再登陆的购物车就清空了。考虑如何实现持久化？新建购物车表，还是放在用户表中新的字段？
                //todo 4 如果采用新表，可以考虑这样的结构，订单表，新增状态字段，0为购物车中状态，1为已购买状态，如2、3可以是退款，取消等其他状态。
                //todo 4 增加数据字典表，增加双键作为主键如1000定义类型，1定义该类型中的状态
                Map<String,Integer> isbns =  (Map<String,Integer>)object;
                BookBiz biz = new BookBiz();
                try {
                    List<TBook> books = biz.getBooks(isbns.keySet());
                    request.setAttribute("books",books);
                    result = "/main/ShopCar.jsp";
                } catch (Exception e) {
                    Log.logger.error(e.getMessage());
                    request.setAttribute("msg", "网络异常，请和管理员联系");
                    result = "/error.jsp";
                }

            }else {
                result = "/main/ShopCar.jsp";
            }
        }else{
            request.setAttribute("msg","你访问了受限页面，请先登录");
            result = "/main/login.jsp";
        }
        return result;
    }


    /**
     * 购物车结算功能
     * @param request
     * @return
     */
    @RequestMapping("/checkOut")
    public String checkOut(HttpServletRequest request) {
        String result = null;

        if(request.getSession().getAttribute("user") != null){                 //先判断用户是否登录
            Object object = request.getSession().getAttribute("ShopCar");
            if(object != null){
                Map<String,Integer> isbns = (Map<String,Integer>)object;
                BookBiz biz = new BookBiz();
                try {
                    List<TBook> books = biz.getBooks(isbns.keySet());
                    for(TBook book : books){
                        String value = request.getParameter(book.getIsbn());
                        int bookCount = 1;
                        try {
                            if(value != null && !value.trim().equals("")){
                                bookCount = Integer.parseInt(value);
                                book.setBuyCount(bookCount);                   //储存购买数量
                                isbns.put(book.getIsbn(),bookCount);           //把书的购买数量，存储到了Session中
                            }
                        } catch (Exception e) {
                            Log.logger.error("购买图书的数量应为整数:" + e.getMessage());
                        }
                    }
                    double allMoney = 0;
                    for(TBook bk : books){
                        allMoney = allMoney + bk.getPrice()*bk.getBuyCount();
                    }
                    request.setAttribute("books", books);
                    request.setAttribute("allMoney",allMoney);
                    result = "/main/Checkout.jsp";

                } catch (Exception e) {
                    request.setAttribute("msg", "网络异常，请和管理员联系");
                    result = "/error.jsp";
                }
            }else{
                request.setAttribute("msg", "网络异常，请和管理员联系");
                result = "/error.jsp";
            }
        }else{
            request.setAttribute("msg","你访问了受限页面，请先登录");
            result = "/main/login.jsp";
        }
        return result;
    }


    /**
     * 订单付款功能，POST方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/payMoney", method = RequestMethod.POST)
    public String payMoney(HttpServletRequest request) {
        String result = null;

        if(request.getSession().getAttribute("user") != null){ //判断是否登录
            String value = request.getParameter("allMoney");
            if(value != null){
                double allMoney = Double.parseDouble(value);
                UserBiz biz = new UserBiz();
                TUser user = (TUser)request.getSession().getAttribute("user");
                Map<String,Integer> car =  (Map<String,Integer>)request.getSession().getAttribute("ShopCar");
                try {
                    biz.buyBooks(user.getUname(), allMoney,car);
                    car.clear();
                    //request.getRequestDispatcher("/main/PaySuccess.jsp").forward(request, response);
                    String path = request.getContextPath();
                    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
                    //hint：为了避免重复付款，要使用重定向，同时因为不能直接访问WEB-INF下的jsp，所以需要action来跳转
                    result = "redirect:/user/payMoney.do";
                } catch (Exception e) {
                    request.setAttribute("msg", "网络异常，请和管理员联系");
                    result = "/error.jsp";
                }
            }else {
                request.setAttribute("msg", "网络异常，请和管理员联系");
                result = "/error.jsp";
            }
        }else {
            request.setAttribute("msg", "访问了首先页面，请先登录");
            result = "/main/login.jsp";
        }

        return result;
    }

    /**
     * 订单付款功能，GET方法
     * @return
     */
    @RequestMapping(value = "/payMoney", method = RequestMethod.GET)
    public String payMoney() {
        return "/main/PaySuccess.jsp";
    }






}
