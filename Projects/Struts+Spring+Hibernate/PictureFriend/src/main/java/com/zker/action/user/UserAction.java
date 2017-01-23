package com.zker.action.user;

import com.zker.action.BaseAction;
import com.zker.common.Constant;
import com.zker.common.exception.BusinessException;
import com.zker.dao.user.UserDao;
import com.zker.dao.user.UserDaoImpl;
import com.zker.model.job.SysJob;
import com.zker.model.product.ProductSort;
import com.zker.model.user.SysUser;
import com.zker.service.job.JobService;
import com.zker.service.product.ProductSortService;
import com.zker.service.user.UserService;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

/**
 * zker 图友网模拟项目
 * FileName:UserAction
 * <p>用户的Action类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-24 Dulk
 */
public class UserAction extends BaseAction implements ServletContextAware{
    /**用户类，用来封装信息*/
    private SysUser sysUser;

    /**用户类的业务层*/
    private UserService userService;

    /**作品分类的业务层*/
    private ProductSortService productSortService;

    /**职位类的业务层*/
    private JobService jobService;

    /**数据封装用的字符串*/
    private String findByIdResult = "update";

    /**数据封装用的旧密码*/
    private String oldPassword;

    /**数据封装用的File，封装头像信息*/
    private File image;

    /**一个Servlet上下文对象*/
    private ServletContext servletContext;

    /**封装了头像的内容类型*/
    private String imageContentType;

    /**封装了头像的图片名称*/
    private String imageFileName;

    /**对于默认findByPage中的page为1*/
    private int page = 1;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ProductSortService getProductSortService() {
        return productSortService;
    }

    public void setProductSortService(ProductSortService productSortService) {
        this.productSortService = productSortService;
    }

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public String getFindByIdResult() {
        return findByIdResult;
    }

    public void setFindByIdResult(String findByIdResult) {
        this.findByIdResult = findByIdResult;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    @Override
    public void setServletContext(ServletContext context) {
        this.servletContext = context;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 用户注册
     * @return
     */
    public String register() {
        sysUser.setRegisterTime(getCurTime());
        try {
            SysUser user = userService.register(sysUser);//封装注册的用户信息到登录信息中
            getSession().put(Constant.SESSION_USER, user);//将登录信息写入session中，直接登录
            List<ProductSort> productSorts = productSortService.findAll();
            getSession().put("productSorts", productSorts);
        } catch (BusinessException e) {
            //如果用户名注册有重名
            getRequest().put("message", e.getMessage());
            return "registerInput";
        }
        //符合用户注册规范
        return "register";
    }


    /**
     * 根据用户id获取用户信息，并将职业信息获取，写入request
     * @return
     */
    public String findById() {
        List<SysJob> jobs = jobService.findAll();
        getRequest().put("sysJobs", jobs);
        this.sysUser = userService.findById(sysUser.getUserId());
        return findByIdResult;
    }


    /**
     * 更新用户修改后的信息
     * @return
     */
    public String updateInfor() {
        userService.updateInfor(sysUser);
        getRequest().put("message", "用户信息修改成功");
        SysUser su = userService.findById(sysUser.getUserId());
        getSession().put(Constant.SESSION_USER, su);
        return "updateInfor";
    }

    /**
     * 更新用户密码
     * @return
     */
    public String updatePassword() {
        if (!getCurUser().getPassword().equals(oldPassword)) {
            getRequest().put("message", "密码输入错误");
            return "updatePasswordInput";
        }
        SysUser su = getCurUser();
        su.setPassword(sysUser.getPassword());
        userService.updatePassword(su);
        getRequest().put("message", "用户密码修改成功");
        return "updatePassword";
    }

    /**
     * 更新账户头像信息
     * @return
     */
    public String updateImage() {
        String realPath = servletContext.getRealPath("/");
        //获得文件的后缀（文件类型）
        String extension = imageFileName.substring(imageFileName.lastIndexOf("."));
        //以当前时间的毫秒数为文件名，加上文件后缀
        String imageName = getCurDate().getTime() + extension;

        //保存到数据库中的路径
        String savedPath = "upload/userImage/" + imageName;
        sysUser.setImageUrl(savedPath);
        userService.updateImage(sysUser, image, realPath);
        getRequest().put("message", "用户头像上传成功");
        SysUser temp = userService.findById(sysUser.getUserId());
        getSession().put(Constant.SESSION_USER, temp);
        return "updateImage";

    }

    /**
     * 查找指定页码的用户信息
     * @return
     */
    public String findByPage() {
        List<SysUser> sysUsers = userService.findByPage(page);
        getRequest().put("sysUsers", sysUsers);
        int count = userService.findCount();
        //总页数=总数/每页数量（分奇偶情况进行计算）
        int pageCount =
                count % Constant.USER_NUMBER_PAGE == 0 ?
                        count / Constant.USER_NUMBER_PAGE : count / Constant.USER_NUMBER_PAGE + 1;
        getRequest().put("pageCount", pageCount);
        return "findByPage";
    }

    /**
     * 解锁用户
     * @return
     */
    public String unLockUser() {
        userService.unLockUser(sysUser.getUserId());
        return "unLockUser";
    }

    /**
     * 锁定用户
     * @return
     */
    public String lockUser() {
        userService.lockUser(sysUser.getUserId());
        return "lockUser";
    }


}
