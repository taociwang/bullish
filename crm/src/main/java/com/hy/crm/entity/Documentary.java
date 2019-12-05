package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 跟单表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer docid;

    /**
     * 跟单时间
     */
    private String date;

    /**
     * 跟单主题
     */
    private String topic;

    /**
     * 跟单人
     */
    private String dpeople;

    /**
     * 详情类容
     */
    private String particular;

    /**
     * 上传附件
     */
    private String accessory;

    /**
     * 状态 0：处理完成 1：处理中
     */
    private Integer stute;

    /**
     * 外键 跟单分类
     */
    private String deId;

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getDpeople() {
        return dpeople;
    }

    public void setDpeople(String dpeople) {
        this.dpeople = dpeople;
    }
    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }
    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }
    public Integer getStute() {
        return stute;
    }

    public void setStute(Integer stute) {
        this.stute = stute;
    }
    public String getDeId() {
        return deId;
    }

    public void setDeId(String deId) {
        this.deId = deId;
    }

    @Override
    public String toString() {
        return "Documentary{" +
        "docid=" + docid +
        ", date=" + date +
        ", topic=" + topic +
        ", dpeople=" + dpeople +
        ", particular=" + particular +
        ", accessory=" + accessory +
        ", stute=" + stute +
        ", deId=" + deId +
        "}";
    }
}
