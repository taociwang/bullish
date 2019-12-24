package com.hy.crm.util;

import lombok.Getter;
import lombok.Setter;

import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LayuiData implements Serializable {
    private Integer code;
    private String msg;
    private long count;
    private List data;

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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
