package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 权限菜单表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 功能名称
     */
    private String aname;

    /**
     * 路径
     */
    private String url;

    /**
     * 上级urlid
     */
    private Integer parentid;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Authority{" +
        "aname=" + aname +
        ", url=" + url +
        ", parentid=" + parentid +
        "}";
    }
}
