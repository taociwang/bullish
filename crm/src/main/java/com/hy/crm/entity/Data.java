package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 基本数据管理表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 基本数据管理主键did
     */
    private Integer did;

    /**
     * 类型id
     */
    private Integer typeid;

    /**
     * 类型名称
     */
    private String type_name;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Data{" +
        "did=" + did +
        ", typeid=" + typeid +
        ", type_name=" + type_name +
        "}";
    }
}
