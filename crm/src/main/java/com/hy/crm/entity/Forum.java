package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 论坛表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@TableName("forum")
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 论坛主键fid
     */
    @TableId(type = IdType.AUTO)
    private Integer fid;

    /**
     * 论坛主题
     */
    private String theme;

    /**
     * 论坛作者
     */
    private String theme_author;

    /**
     * 所属商机
     */
    private String business;

    /**
     * 点击量
     */
    private Integer click;

    /**
     * 回复量
     */
    private Integer reply;
    /**
     * 最后回复时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String reply_time;

    /**
     * 帖子分类
     */
    private String invitation_uppere;

    /**
     * 帖子标签
     */
    private String label;

    /**
     * 帖子相关附件
     */
    @TableField("related_accessory")
    private String related_accessory;
    /**
     * 发帖内容
     */
    @TableField("neirong")
    private String neirong;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getTheme_author() {
        return theme_author;
    }

    public void setTheme_author(String theme_author) {
        this.theme_author = theme_author;
    }
    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }
    public String getInvitation_uppere() {
        return invitation_uppere;
    }

    public void setInvitation_uppere(String invitation_uppere) {
        this.invitation_uppere = invitation_uppere;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getRelated_accessory() {
        return related_accessory;
    }

    public void setRelated_accessory(String related_accessory) {
        this.related_accessory = related_accessory;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    @Override
    public String toString() {
        return "Forum{" +
        "fid=" + fid +
        ", theme=" + theme +
        ", theme_author=" + theme_author +
        ", business=" + business +
        ", click=" + click +
        ", reply=" + reply +
        ", invitation_uppere=" + invitation_uppere +
        ", label=" + label +
        ", related_accessory=" + related_accessory +
        ", neirong=" + neirong +
        "}";
    }
}
