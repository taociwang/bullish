package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 收入登记表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Income implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收入id
     */
    private Integer sid;

    /**
     * 收入日期
     */
    private String income_date;

    /**
     * 收入金额
     */
    private Integer income_money;

    /**
     * 收款方式
     */
    private String income_way;

    /**
     * 关联人员
     */
    private String relevance;

    /**
     * 对方单位
     */
    private String unit;

    /**
     * 收入说明
     */
    private String income_explain;

    /**
     * 收入分类
     */
    private String explain_classify;

    /**
     * 收入大写
     */
    private String daxie;

    /**
     * 登记人
     */
    private String registrant;

    /**
     * 关联部门
     */
    private String department;

    /**
     * 关联合同
     */
    private String contract;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getIncome_date() {
        return income_date;
    }

    public void setIncome_date(String income_date) {
        this.income_date = income_date;
    }
    public Integer getIncome_money() {
        return income_money;
    }

    public void setIncome_money(Integer income_money) {
        this.income_money = income_money;
    }
    public String getIncome_way() {
        return income_way;
    }

    public void setIncome_way(String income_way) {
        this.income_way = income_way;
    }
    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getIncome_explain() {
        return income_explain;
    }

    public void setIncome_explain(String income_explain) {
        this.income_explain = income_explain;
    }
    public String getExplain_classify() {
        return explain_classify;
    }

    public void setExplain_classify(String explain_classify) {
        this.explain_classify = explain_classify;
    }
    public String getDaxie() {
        return daxie;
    }

    public void setDaxie(String daxie) {
        this.daxie = daxie;
    }
    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Income{" +
        "sid=" + sid +
        ", income_date=" + income_date +
        ", income_money=" + income_money +
        ", income_way=" + income_way +
        ", relevance=" + relevance +
        ", unit=" + unit +
        ", income_explain=" + income_explain +
        ", explain_classify=" + explain_classify +
        ", daxie=" + daxie +
        ", registrant=" + registrant +
        ", department=" + department +
        ", contract=" + contract +
        "}";
    }
}
