package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.bo.Doc_Data;

import java.util.List;

public interface IDoc_dataService extends IService<Doc_Data> {
    public List<Doc_Data> querydd();
}
