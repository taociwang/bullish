package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.Doc_Data;
import com.hy.crm.mapper.Doc_dataMapper;
import com.hy.crm.service.IDoc_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Doc_dataServicelmpl extends ServiceImpl<Doc_dataMapper,Doc_Data> implements IDoc_dataService {
    @Autowired
    private Doc_dataMapper doc_dataMapper;
    @Override
    public List<Doc_Data> querydd() {
        return doc_dataMapper.qureydd();
    }
}
