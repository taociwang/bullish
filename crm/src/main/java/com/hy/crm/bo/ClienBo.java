package com.hy.crm.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@TableName(value = "clien")
public class ClienBo implements Serializable {
    private Integer cid;

    private String uname;
    //商机的count
    private Integer bcount;
    //商机的sum
    private Integer bsum;

    private Integer acount;
    private Integer asum;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getBcount() {
        return bcount;
    }

    public void setBcount(Integer bcount) {
        this.bcount = bcount;
    }

    public Integer getBsum() {
        return bsum;
    }

    public void setBsum(Integer bsum) {
        this.bsum = bsum;
    }

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    public Integer getAsum() {
        return asum;
    }

    public void setAsum(Integer asum) {
        this.asum = asum;
    }
}
