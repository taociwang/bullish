package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态 0不可在登入，1可登录
     */
    private Integer state;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
        "username=" + username +
        ", password=" + password +
        ", phone=" + phone +
        ", state=" + state +
        "}";
    }
}
