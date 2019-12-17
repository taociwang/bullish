package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Data;
import com.hy.crm.mapper.DataMapper;
import com.hy.crm.service.IDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 基本数据管理表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, Data> implements IDataService {
    @Autowired
    private DataMapper dataMapper;

    /**
     * 根据typeid查询所有类别
     * @param typeid
     * @return
     */
    public List<Data> queryDataType(String typeid){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("typeid",typeid);
        return dataMapper.selectList(wrapper);
    }

}
