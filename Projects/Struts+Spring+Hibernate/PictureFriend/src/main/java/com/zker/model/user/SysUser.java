package com.zker.model.user;

import com.zker.model.comment.ProductComment;
import com.zker.model.job.SysJob;
import com.zker.model.login.SysLogin;
import com.zker.model.product.Product;
import com.zker.model.product.ProductQuery;
import com.zker.model.reply.CommentReply;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * zker 图友网模拟项目
 * FileName:SysUser
 * <p>普通用户的实体VO类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class SysUser {
    /**用户的主键ID*/
    private int userId;

    /**用户的登录账号名*/
    private String loginName;

    /**用户的用户名*/
    private String userName;

    /**用户登录的密码*/
    private String password;

    /**用户的email*/
    private String email;

    /**用户的头像图片路径*/
    private String imageUrl;

    /**用户的性别*/
    private boolean isMale;

    /**用户的电话号码*/
    private String phoneNum;

    /**用户的生日*/
    private Date birthday;

    /**用户注册的时间*/
    private Timestamp registerTime;

    /**用户账户是否锁定*/
    private boolean isLock;

    /**用户对应的职位*/
    private SysJob sysJob;

    /**用户对应的登录表*/
    private Set<SysLogin> sysLogin = new HashSet<SysLogin>();

    /**用户对应的作品表*/
    private Set<Product> products = new HashSet<Product>();

    /**用户对应的作品查询表*/
    private Set<ProductQuery> productQueries = new HashSet<ProductQuery>();

    /**用户对应的作品评论表*/
    private Set<ProductComment> productComments = new HashSet<ProductComment>();

    /**用户对应的回复表*/
    private Set<CommentReply> commentReplies = new HashSet<CommentReply>();

    //属性的getter和setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(boolean islock) {
        this.isLock = islock;
    }

    public SysJob getSysJob() {
        return sysJob;
    }

    public void setSysJob(SysJob sysJob) {
        this.sysJob = sysJob;
    }

    public Set<SysLogin> getSysLogin() {
        return sysLogin;
    }

    public void setSysLogin(Set<SysLogin> sysLogin) {
        this.sysLogin = sysLogin;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<ProductQuery> getProductQueries() {
        return productQueries;
    }

    public void setProductQueries(Set<ProductQuery> productQueries) {
        this.productQueries = productQueries;
    }

    public Set<ProductComment> getProductComments() {
        return productComments;
    }

    public void setProductComments(Set<ProductComment> productComments) {
        this.productComments = productComments;
    }

    public Set<CommentReply> getCommentReplies() {
        return commentReplies;
    }

    public void setCommentReplies(Set<CommentReply> commentReplies) {
        this.commentReplies = commentReplies;
    }
}
