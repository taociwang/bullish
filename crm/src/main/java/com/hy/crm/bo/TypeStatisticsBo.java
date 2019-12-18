package com.hy.crm.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeStatisticsBo implements Serializable {
    private String typeName;
    private Integer count;
    private Integer sum;


}
