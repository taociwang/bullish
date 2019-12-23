package com.hy.crm.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;


public class StatisticsBo implements Serializable {
    private String username;
    private Integer count;

    private Integer bus_count;
    private Integer bus_last_coutn;
    private Integer doc_count;
    private Integer doc_last_coutn;
    private Integer succ_count;
    private Integer succ_last_coutn;
    private Integer con_count;
    private Integer con_last_coutn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBus_count() {
        return bus_count;
    }

    public void setBus_count(Integer bus_count) {
        this.bus_count = bus_count;
    }

    public Integer getBus_last_coutn() {
        return bus_last_coutn;
    }

    public void setBus_last_coutn(Integer bus_last_coutn) {
        this.bus_last_coutn = bus_last_coutn;
    }

    public Integer getDoc_count() {
        return doc_count;
    }

    public void setDoc_count(Integer doc_count) {
        this.doc_count = doc_count;
    }

    public Integer getDoc_last_coutn() {
        return doc_last_coutn;
    }

    public void setDoc_last_coutn(Integer doc_last_coutn) {
        this.doc_last_coutn = doc_last_coutn;
    }

    public Integer getSucc_count() {
        return succ_count;
    }

    public void setSucc_count(Integer succ_count) {
        this.succ_count = succ_count;
    }

    public Integer getSucc_last_coutn() {
        return succ_last_coutn;
    }

    public void setSucc_last_coutn(Integer succ_last_coutn) {
        this.succ_last_coutn = succ_last_coutn;
    }

    public Integer getCon_count() {
        return con_count;
    }

    public void setCon_count(Integer con_count) {
        this.con_count = con_count;
    }

    public Integer getCon_last_coutn() {
        return con_last_coutn;
    }

    public void setCon_last_coutn(Integer con_last_coutn) {
        this.con_last_coutn = con_last_coutn;
    }
}
