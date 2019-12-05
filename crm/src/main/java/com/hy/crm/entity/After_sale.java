package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 售后
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class After_sale implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主题
     */
    private String theme;

    /**
     * 客户id
     */
    private String clientid;

    /**
     * 合同外键
     */
    private Integer contractid;

    /**
     * 电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 服务类型
     */
    private String serve_type;

    /**
     * 开始时间
     */
    private String state_time;

    /**
     * 结束时间
     */
    private String end_time;

    /**
     * 服务类容
     */
    private String serve_content;

    /**
     * 客户反馈
     */
    private String contarc_tfeedback;

    /**
     * 服务人员
     */
    private String serve_per;

    private String accessory;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }
    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getServe_type() {
        return serve_type;
    }

    public void setServe_type(String serve_type) {
        this.serve_type = serve_type;
    }
    public String getState_time() {
        return state_time;
    }

    public void setState_time(String state_time) {
        this.state_time = state_time;
    }
    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public String getServe_content() {
        return serve_content;
    }

    public void setServe_content(String serve_content) {
        this.serve_content = serve_content;
    }
    public String getContarc_tfeedback() {
        return contarc_tfeedback;
    }

    public void setContarc_tfeedback(String contarc_tfeedback) {
        this.contarc_tfeedback = contarc_tfeedback;
    }
    public String getServe_per() {
        return serve_per;
    }

    public void setServe_per(String serve_per) {
        this.serve_per = serve_per;
    }
    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return "After_sale{" +
        "theme=" + theme +
        ", clientid=" + clientid +
        ", contractid=" + contractid +
        ", phone=" + phone +
        ", contact=" + contact +
        ", serve_type=" + serve_type +
        ", state_time=" + state_time +
        ", end_time=" + end_time +
        ", serve_content=" + serve_content +
        ", contarc_tfeedback=" + contarc_tfeedback +
        ", serve_per=" + serve_per +
        ", accessory=" + accessory +
        "}";
    }
}
