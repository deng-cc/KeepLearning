package com.zker.action.main;

import com.zker.action.BaseAction;
import com.zker.model.main.SysMain;
import com.zker.service.main.MainService;
import com.zker.service.main.MainServiceImpl;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

public class MainAction extends BaseAction implements ServletContextAware{
    /**封装主页图片*/
    private File image;

    /**图片的类型*/
    private String imageContentType;

    /**图片的名称*/
    private String imageFileName;

    /**主页管理业务层*/
    private MainService mainService;

    /**ServletContext Servlet上下文*/
    private ServletContext servletContext;

    /**封装图片信息*/
    private SysMain sysMain;

    //getter and setter -- start
    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
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

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public MainService getMainService() {
        return mainService;
    }

    public void setMainService(MainServiceImpl mainService) {
        this.mainService = mainService;
    }

    public SysMain getSysMain() {
        return sysMain;
    }

    public void setSysMain(SysMain sysMain) {
        this.sysMain = sysMain;
    }

    //getter and setter -- end

    /**
     * 保存主页图片
     * @return
     */
    public String save() {
        SysMain sa = new SysMain();
        sa.setImageName(imageFileName);
        String path = servletContext.getRealPath("/upload/main/");
        String extension = imageFileName.substring(imageFileName.lastIndexOf("."));

        /*
        //todo 暂且使用该方式来判断图片后缀和类型，后续应修改为struts的拦截器方式
        if ( (!extension.equals(".png")) && (!extension.equals(".jpg")) ) {
            getRequest().put("msg", "要求图片格式为jpg、png格式！");
            return "save";
        }
        */

        //修改图片名，防止管理员两次提交同名文件
        String imageName = getCurDate().getTime() + extension;
        //保存到数据库中的路径
        String savePath = "upload/main/" + imageName;
        sa.setImageUrl(savePath);
        mainService.save(sa, this.image, path + "/" + imageName);
        getRequest().put("msg", "图片上传成功！");
        return "save";
    }

    /**
     * 查找所有的主页图片信息
     * @return
     */
    public String findAllMain() {
        List<SysMain> lists = mainService.findAllMain();
        getRequest().put("allMain", lists);
        return "findAllMain";
    }

    /**
     * 删除指定的图片
     * 根据图片的主键对其进行删除操作
     * @return
     */
    public String deleteMain() {
        mainService.delete(this.sysMain);
        getRequest().put("msg", "图片删除成功！");
        return "delete";
    }

    /**
     * 当上传图片格式不符要求时，调用该方法
     * @return
     */
    public String input() {
        getRequest().put("msg", "上传格式不符合要求！");
        List<SysMain> lists = mainService.findAllMain();
        getRequest().put("allMain", lists);
        return "findAllMain";
    }
}
