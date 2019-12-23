package com.hy.crm.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hy.crm.entity.Clien;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Data;

import java.io.Serializable;

@TableName("after_sale")
public class After_sale_bo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private Clien clien;
    @TableField(exist = false)
    private Contract contract;
    @TableField(exist = false)
    private Data data;

    @TableId(type = IdType.UUID)
    private String id;

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

    /**
     * 附件
     */
    private String accessory;

    /**
     * 状态 1,处理中，2，已完成，3.已撤销
     */
    private String status;

    /**
     * 服务评分
     */
    private Integer serve_grade;

    public Integer getServe_grade() {
        return serve_grade;
    }

    public void setServe_grade(Integer serve_grade) {
        this.serve_grade = serve_grade;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public Clien getClien() {
        return clien;
    }

    public void setClien(Clien clien) {
        this.clien = clien;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
