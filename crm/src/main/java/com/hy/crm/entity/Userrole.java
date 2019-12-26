package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 用户权限表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表id
     */
    private Integer userid;

    /**
     * 角色id
     */
    private Integer roleid;
    private Integer[] userR;

    public Integer[] getUserR() {
        return userR;
    }

    public void setUserR(Integer[] userR) {
        this.userR = userR;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Userrole{" +
        "userid=" + userid +
        ", roleid=" + roleid +
        "}";
    }
}
