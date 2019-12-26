package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Roleauthority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer roleid;

    /**
     * 权限id
     */
    private Integer authorityid;
    @TableField(exist = false)
    private Integer[] roleauth;

    public Integer[] getRoleauth() {
        return roleauth;
    }

    public void setRoleauth(Integer[] roleauth) {
        this.roleauth = roleauth;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    @Override
    public String toString() {
        return "Roleauthority{" +
        "roleid=" + roleid +
        ", authorityid=" + authorityid +
        "}";
    }
}
