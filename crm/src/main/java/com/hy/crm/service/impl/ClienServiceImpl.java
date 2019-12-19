package com.hy.crm.service.impl;

import com.github.pagehelper.Page;
import com.hy.crm.entity.Clien;
import com.hy.crm.mapper.ClienBoMapper;
import com.hy.crm.mapper.ClienMapper;
import com.hy.crm.service.IClienService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class ClienServiceImpl extends ServiceImpl<ClienMapper, Clien> implements IClienService {
    @Autowired
    private ClienMapper clienMapper;
    @Autowired
    private ClienBoMapper clienBoMapper;

    public List<Clien> queryCli(String value, String type, String typeid){
        List<Clien> list=new ArrayList<>();
        if (value!=null && type!=null){
            list= clienBoMapper.queryCli(value, type);
        }else if (null !=typeid){
            list= clienBoMapper.querynoe(typeid);
        } else if (value ==null && type ==null){
           list = clienBoMapper.queryCli(value, type);
        } else if (typeid ==null){
            list= clienBoMapper.querynoe(typeid);
        }else if(value!=null&&type==null){
            String s=value=null;
            list = clienBoMapper.queryCli(s, type);
        }
        return list;
    }

}
