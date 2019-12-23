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
}
