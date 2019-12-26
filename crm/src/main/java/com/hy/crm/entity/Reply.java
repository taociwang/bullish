package com.hy.crm.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 帖子回复表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复人id
     */
    private Integer reply_id;

    /**
     * 回复人姓名
     */
    private String reply_name;
    /**
     * 回复内容
     */
    private String replycontent;

    /**
     * 帖子回复时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reply_time;

    private String fid;

    /*
    * 回复内容
    * */
    private String eplycontent;

    public String getEplycontent() {
        return eplycontent;
    }

    public void setEplycontent(String eplycontent) {
        this.eplycontent = eplycontent;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }
    public String getReply_name() {
        return reply_name;
    }

    public void setReply_name(String reply_name) {
        this.reply_name = reply_name;
    }

    public Date getReply_time() {
        return reply_time;
    }

    public void setReply_time(Date reply_time) {
        this.reply_time = reply_time;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "reply_id=" + reply_id +
                ", reply_name='" + reply_name + '\'' +
                ", reply_time='" + reply_time + '\'' +
                ", eplycontent='" + eplycontent + '\'' +
                '}';
    }
}
