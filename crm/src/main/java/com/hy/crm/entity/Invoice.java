package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 开票申请单表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开票id
     */
    private Integer tid;

    /**
     * 申请人姓名
     */
    private String proposer;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 申请日期
     */
    private String department_date;

    /**
     * 技术条款
     */
    private String technology_money;

    /**
     * 对方单位名称
     */
    private String unit_name;

    /**
     * 关联合同
     */
    private String gl_contract;

    /**
     * 开票种类
     */
    private String kind;

    /**
     * 纳税人识别号
     */
    private String ratepayer_number;

    /**
     * 开户行及账号
     */
    private String opening_bank;

    /**
     * 地址和电话
     */
    private String address_phone;

    /**
     * 开票金额
     */
    private Integer money;

    /**
     * 金额大写
     */
    private String money_daxie;

    /**
     * 开票日期
     */
    private String kaipiao_date;

    /**
     * 发票号码
     */
    private String invoice_number;

    /**
     * 附件
     */
    private String accessory;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment_date() {
        return department_date;
    }

    public void setDepartment_date(String department_date) {
        this.department_date = department_date;
    }
    public String getTechnology_money() {
        return technology_money;
    }

    public void setTechnology_money(String technology_money) {
        this.technology_money = technology_money;
    }
    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }
    public String getGl_contract() {
        return gl_contract;
    }

    public void setGl_contract(String gl_contract) {
        this.gl_contract = gl_contract;
    }
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getRatepayer_number() {
        return ratepayer_number;
    }

    public void setRatepayer_number(String ratepayer_number) {
        this.ratepayer_number = ratepayer_number;
    }
    public String getOpening_bank() {
        return opening_bank;
    }

    public void setOpening_bank(String opening_bank) {
        this.opening_bank = opening_bank;
    }
    public String getAddress_phone() {
        return address_phone;
    }

    public void setAddress_phone(String address_phone) {
        this.address_phone = address_phone;
    }
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
    public String getMoney_daxie() {
        return money_daxie;
    }

    public void setMoney_daxie(String money_daxie) {
        this.money_daxie = money_daxie;
    }
    public String getKaipiao_date() {
        return kaipiao_date;
    }

    public void setKaipiao_date(String kaipiao_date) {
        this.kaipiao_date = kaipiao_date;
    }
    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }
    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return "Invoice{" +
        "tid=" + tid +
        ", proposer=" + proposer +
        ", department=" + department +
        ", department_date=" + department_date +
        ", technology_money=" + technology_money +
        ", unit_name=" + unit_name +
        ", gl_contract=" + gl_contract +
        ", kind=" + kind +
        ", ratepayer_number=" + ratepayer_number +
        ", opening_bank=" + opening_bank +
        ", address_phone=" + address_phone +
        ", money=" + money +
        ", money_daxie=" + money_daxie +
        ", kaipiao_date=" + kaipiao_date +
        ", invoice_number=" + invoice_number +
        ", accessory=" + accessory +
        "}";
    }
}
