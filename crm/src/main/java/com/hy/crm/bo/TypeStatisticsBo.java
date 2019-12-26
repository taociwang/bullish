package com.hy.crm.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeStatisticsBo implements Serializable {
    //类型名称
    private String typeName;
    //类型成交数量
    private Integer count;
    //成交总金额
    private Integer sum;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
