package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 合同表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合同主键cid
     */
    private Integer cid;

    /**
     * 合同全称
     */
    private String contract_name;

    /**
     * 合同编号
     */
    private String contract_number;

    /**
     * 合同金额
     */
    private Long contract_money;

    /**
     * 汇款额
     */
    private String remittance;

    /**
     * 开票额
     */
    private String kaipiao_money;

    /**
     * 签约日期
     */
    private String contract_date;

    /**
     * 生效日期
     */
    private String effective_date;

    /**
     * 服务期至
     */
    private String period_of_service;

    /**
     * 对方联系人
     */
    private String opposite_ren;

    /**
     * 固定电话
     */
    private Integer immobilization_phone;

    /**
     * 移动电话
     */
    private Integer move_phone;

    /**
     * 邮箱/qq
     */
    private String e_mail_qq;

    /**
     * 主要技术条款
     */
    private String js_clause;

    /**
     * 主要商务条款
     */
    private String sw_clause;

    /**
     * 相关附件
     */
    private String xg_accessory;

    /**
     * 所属部门
     */
    private String con_department;

    /**
     * 关联人员
     */
    private String gl_person;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }
    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }
    public Long getContract_money() {
        return contract_money;
    }

    public void setContract_money(Long contract_money) {
        this.contract_money = contract_money;
    }
    public String getRemittance() {
        return remittance;
    }

    public void setRemittance(String remittance) {
        this.remittance = remittance;
    }
    public String getKaipiao_money() {
        return kaipiao_money;
    }

    public void setKaipiao_money(String kaipiao_money) {
        this.kaipiao_money = kaipiao_money;
    }
    public String getContract_date() {
        return contract_date;
    }

    public void setContract_date(String contract_date) {
        this.contract_date = contract_date;
    }
    public String getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(String effective_date) {
        this.effective_date = effective_date;
    }
    public String getPeriod_of_service() {
        return period_of_service;
    }

    public void setPeriod_of_service(String period_of_service) {
        this.period_of_service = period_of_service;
    }
    public String getOpposite_ren() {
        return opposite_ren;
    }

    public void setOpposite_ren(String opposite_ren) {
        this.opposite_ren = opposite_ren;
    }
    public Integer getImmobilization_phone() {
        return immobilization_phone;
    }

    public void setImmobilization_phone(Integer immobilization_phone) {
        this.immobilization_phone = immobilization_phone;
    }
    public Integer getMove_phone() {
        return move_phone;
    }

    public void setMove_phone(Integer move_phone) {
        this.move_phone = move_phone;
    }
    public String getE_mail_qq() {
        return e_mail_qq;
    }

    public void setE_mail_qq(String e_mail_qq) {
        this.e_mail_qq = e_mail_qq;
    }
    public String getJs_clause() {
        return js_clause;
    }

    public void setJs_clause(String js_clause) {
        this.js_clause = js_clause;
    }
    public String getSw_clause() {
        return sw_clause;
    }

    public void setSw_clause(String sw_clause) {
        this.sw_clause = sw_clause;
    }
    public String getXg_accessory() {
        return xg_accessory;
    }

    public void setXg_accessory(String xg_accessory) {
        this.xg_accessory = xg_accessory;
    }
    public String getCon_department() {
        return con_department;
    }

    public void setCon_department(String con_department) {
        this.con_department = con_department;
    }
    public String getGl_person() {
        return gl_person;
    }

    public void setGl_person(String gl_person) {
        this.gl_person = gl_person;
    }

    @Override
    public String toString() {
        return "Contract{" +
        "cid=" + cid +
        ", contract_name=" + contract_name +
        ", contract_number=" + contract_number +
        ", contract_money=" + contract_money +
        ", remittance=" + remittance +
        ", kaipiao_money=" + kaipiao_money +
        ", contract_date=" + contract_date +
        ", effective_date=" + effective_date +
        ", period_of_service=" + period_of_service +
        ", opposite_ren=" + opposite_ren +
        ", immobilization_phone=" + immobilization_phone +
        ", move_phone=" + move_phone +
        ", e_mail_qq=" + e_mail_qq +
        ", js_clause=" + js_clause +
        ", sw_clause=" + sw_clause +
        ", xg_accessory=" + xg_accessory +
        ", con_department=" + con_department +
        ", gl_person=" + gl_person +
        "}";
    }
}
