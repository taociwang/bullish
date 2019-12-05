package com.hy.crm.entity;

import java.io.Serializable;

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
     * 帖子回复时间
     */
    private String reply_time;

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
    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    @Override
    public String toString() {
        return "Reply{" +
        "reply_id=" + reply_id +
        ", reply_name=" + reply_name +
        ", reply_time=" + reply_time +
        "}";
    }
}
