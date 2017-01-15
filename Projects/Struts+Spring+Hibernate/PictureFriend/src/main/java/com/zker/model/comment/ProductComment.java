package com.zker.model.comment;

import com.zker.model.product.Product;
import com.zker.model.reply.CommentReply;
import com.zker.model.user.SysUser;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * zker 图友网模拟项目
 * FileName:ProductComment
 * <p>作品评论的VO实体类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class ProductComment {
    /**
     * 评论的主键ID
     */
    private int commentId;

    /**
     * 评论对应的作品
     */
    private Product product;

    /**
     * 发表评论的账户
     */
    private SysUser sysUser;

    /**
     * 评论的内容
     */
    private String commentContent;

    /**
     * 发表评论的时间
     */
    private Timestamp commentTime;

    /**
     * 该条评论包含的回复内容
     */
    private Set<CommentReply> commentReplies = new HashSet<CommentReply>();

    //属性的getter和setter
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Set<CommentReply> getCommentReplies() {
        return commentReplies;
    }

    public void setCommentReplies(Set<CommentReply> commentReplies) {
        this.commentReplies = commentReplies;
    }
}
