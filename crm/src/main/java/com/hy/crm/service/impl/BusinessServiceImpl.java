package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商机表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    public List<Business> queryBusin( String bname,String syzt,Integer predictsum,String fzr,String sjssbm,String time){
        return businessMapper.queryBus(bname,syzt,predictsum,fzr,sjssbm,time);
    }

    public List<Business> querycli(Integer cid){
        List<Business> list = businessMapper.queryClien(cid);
        return list;
    }
    public List<Business> queryAll(){
        List<Business> list = businessMapper.queryall();
        return list;
    }


}
