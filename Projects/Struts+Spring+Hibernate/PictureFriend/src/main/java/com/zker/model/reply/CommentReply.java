package com.zker.model.reply;

import com.zker.model.comment.ProductComment;
import com.zker.model.user.SysUser;

import java.sql.Timestamp;

/**
 * zker 图友网模拟项目
 * FileName:CommentReply
 * <p>评论回复的实体VO类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class CommentReply {
    /**
     * 回复的主键ID
     */
    private int replyId;

    /**
     * 回复所关联的用户（即谁的回复）
     */
    private SysUser sysUser;

    /**
     * 回复相对应的评论
     */
    private ProductComment productComment;

    /**
     * 回复的内容
     */
    private String replyComment;

    /**
     * 回复的时间
     */
    private Timestamp replyTime;

    //属性的getter和setter
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public ProductComment getProductComment() {
        return productComment;
    }

    public void setProductComment(ProductComment productComment) {
        this.productComment = productComment;
    }

    public String getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }

    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }
}
