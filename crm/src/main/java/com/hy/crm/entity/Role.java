package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String rname;

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
        "rname=" + rname +
        "}";
    }
}
