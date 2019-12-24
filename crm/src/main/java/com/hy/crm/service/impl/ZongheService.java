package com.hy.crm.service.impl;

import com.hy.crm.mapper.Zonghe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZongheService {
    @Autowired
    private Zonghe zonghe;

    public Integer business(){
        return zonghe.business();
    }
    public Integer clien(){
        return zonghe.clien();
    }
    public Integer contract(){
        return zonghe.clien();
    }
}
