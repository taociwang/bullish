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
}
