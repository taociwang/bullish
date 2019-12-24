package com.hy.crm.util;

import lombok.Getter;
import lombok.Setter;

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
