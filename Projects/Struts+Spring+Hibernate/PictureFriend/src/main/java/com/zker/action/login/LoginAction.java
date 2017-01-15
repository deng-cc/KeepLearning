package com.zker.action.login;

import com.zker.action.BaseAction;
import com.zker.common.Constant;
import com.zker.common.util.ImageUtil;
import com.zker.model.login.SysLogin;
import com.zker.model.product.ProductSort;
import com.zker.model.user.SysAdmin;
import com.zker.model.user.SysUser;
import com.zker.service.login.LoginService;
import com.zker.service.product.ProductSortService;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * zker 图友网模拟项目
 * FileName:LoginAction
 * <p>登录的Action</p>
 *
 * @author Dulk
 * @version 1.00 16-10-7 Dulk
 */
public class LoginAction extends BaseAction {

    /**登录的业务处理*/
    private LoginService loginService;

    /**作品分类的业务处理*/
    private ProductSortService productSortService;

    /**图片验证码的输入流*/
    private InputStream imageInputStream;

    /**登录名*/
    private String loginName;
    //@tips 在login.jsp页面的ONGL表达式提交时用户名name为loginName，所以这里必须同名，struts在提交后会自动赋值，此时不同于servlet需要request.getParameter

    /**登录密码*/
    private String password;

    //属性的getter和setter（不含imageInputStream）
    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public ProductSortService getProductSortService() {
        return productSortService;
    }

    public void setProductSortService(ProductSortService productSortService) {
        this.productSortService = productSortService;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取有效的验证码
     * @return
     */
    public String findValidateCode() {
        //创建一组验证码字符，以及验证码图片流，并存入Map
        Map<String, BufferedImage> images = ImageUtil.createImage();
        //获取第一个验证码字符
        String code = images.keySet().iterator().next();
        //根据验证码字符，获取验证码图片流
        BufferedImage image = images.get(code);
        //将图片流转换为inputStream类型，并赋值给imageInputStream
        this.imageInputStream = ImageUtil.getInputStream(image);
        //将验证码写入session中
        getSession().put(Constant.SESSION_VALIDATE, code);
        //返回成功标志
        return "getValidateCode";
    }

    /**
     * 系统的登录
     * 1）普通用户登录成功
     *      返回userSuccess
     * 2）系统管理员登录成功
     *      返回adminSuccess
     * 3）输入错误
     *      返回input
     *          用户名错误 request.put("state", "0");
     *          密码错误   request.put("state", "1");
     *          验证码错误 request.put("state", "2");
     *          用户被锁   request.put("state", "3");
     * @return
     * userSuccess
     * adminSuccess
     * input
     * BUS_EXCEPTION
     */
    public String login() {
        SysUser sysUser = loginService.findUserByLoginName(loginName);
        //根据用户名是否可以在数据库检索到对应的用户信息，即用户名是否输入正确
        if (sysUser != null) {
            return judgeUser(sysUser); //判断登录是否正常（密码是否正确，是否锁定）
        } else {
            return judgeAdmin();
        }
    }

    /**
     * 判断普通用户状态的是否正常（密码是否正确、账户锁定与否）
     * @param sysUser
     * @return
     */
    public String judgeUser(SysUser sysUser) {
        //如果密码符合要求
        if (sysUser.getPassword().equals(password)) {
            //如果用户被锁定
            if (sysUser.getIsLock()) {
                getRequest().put("state", "3");
                return "input";
            } else {
            //如果用户未锁定
                getSession().put(Constant.SESSION_USER, sysUser);//将登录用户写入到session中
                SysLogin loginTemp = new SysLogin();
                loginTemp.setLoginTime(getCurTime());
                loginService.save(loginTemp, sysUser);//保存用户登录信息
                //获取全部作品分类，用于菜单显示，经常使用且不会改变，写入到session中
                List<ProductSort> productSorts = productSortService.findAll();
                getSession().put("productSorts", productSorts);
                return "userSuccess";
            }
        } else {
        //如果密码不符合要求
            getRequest().put("state", "1");//账户存在，但密码不正确
            return "input";
        }
    }

    /**
     * 判断系统管理员状态的是否正常（密码是否正确、账户锁定与否）
     * @return
     */
    public String judgeAdmin() {
        SysAdmin admin = loginService.findAdminByLoginName(loginName);
        //如果系统管理员账号存在
        if (admin != null) {
            //如果账户密码正确
            if (admin.getPassword().equals(password)) {
                getSession().put(Constant.SESSION_USER, admin);//将登录用户写入到session中
                //获取全部作品分类，用于菜单显示，经常使用且不会改变，写入到session中
                List<ProductSort> productSorts = productSortService.findAll();
                getSession().put("productSorts", productSorts);
                return "adminSuccess";
            } else {
            //如果账户密码不正确
                getRequest().put("state", "1");
                return "input";
            }
        } else {
            //如果系统管理员账号不存在
            getRequest().put("state", "0");
            return "input";
        }
    }

    /**
     * 退出系统
     * session中移除登录信息
     * @return
     */
    public String logout() {
        getSession().remove(Constant.SESSION_USER);
        getSession().remove("productSorts");
        return "logout";
    }
}
