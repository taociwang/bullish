package com.hy.crm.util;


import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;

import java.io.Serializable;
import java.util.List;

public class LayuiData implements Serializable {
    public Integer code;
    public String msg;
    public Integer count;
    public List<Clien> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Clien> getData() {
        return data;
    }

    public void setData(List<Clien> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
