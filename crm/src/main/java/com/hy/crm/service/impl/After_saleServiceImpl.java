package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.hy.crm.bo.After_sale_bo;
import com.hy.crm.entity.After_sale;
import com.hy.crm.mapper.After_saleMapper;
import com.hy.crm.service.IAfter_saleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 售后 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class After_saleServiceImpl extends ServiceImpl<After_saleMapper, After_sale> implements IAfter_saleService {
    @Autowired
    private After_saleMapper after_saleMapper;
    /**
     * 查询所有
     */
    public LayuiData query(After_sale after_sale,Integer current,Integer size,String column,String value){
        LayuiData layuiData=new LayuiData();
        //单表分页插件
        Page page = PageHelper.startPage(current, size, true);
        List<After_sale> afterSaleList=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper<After_sale>();
        if((!StringUtil.isEmpty(column))&&(!StringUtil.isEmpty(value))){
            wrapper.like(column,value);
        }
        if(null!=after_sale){
            if(!StringUtil.isEmpty(after_sale.getStatus())){
                if(after_sale.getStatus().equals("week")){
                    afterSaleList=after_saleMapper.week() ;
                }else if(after_sale.getStatus().equals("lastWeek")){
                    afterSaleList=after_saleMapper.lastWeek() ;
                }else if(after_sale.getStatus().equals("month")){
                    afterSaleList=after_saleMapper.month() ;
                }else if(after_sale.getStatus().equals("lastMonth")){
                    afterSaleList=after_saleMapper.lastMonth() ;
                }else if(after_sale.getStatus().equals("quarter")){
                    afterSaleList=after_saleMapper.quarter() ;
                }else if(after_sale.getStatus().equals("lastQuarter")){
                    afterSaleList=after_saleMapper.lastQuarter();
                }else{
                    wrapper.eq("status",after_sale.getStatus());
                    afterSaleList=after_saleMapper.selectList(wrapper);
                }
            }else{
                afterSaleList=after_saleMapper.selectList(wrapper);
            }
        }else{
            afterSaleList=after_saleMapper.selectList(wrapper);
        }
        layuiData.setData(afterSaleList) ;
        layuiData.setCode(0);
        layuiData.setMsg("");
        layuiData.setCount(page.getTotal());
        return layuiData;
    }

    /**
     * 数据
     */
    public List<Long> counts(){
        List<Long> counts=new ArrayList<>();
        for (int i = 1; i <=3 ; i++) {
            QueryWrapper wrapper=new QueryWrapper<After_sale>();
            Page page = PageHelper.startPage(1, 3, true);
            wrapper.eq("status",i+"");
            after_saleMapper.selectList(wrapper);
            counts.add(page.getTotal());
        }
        Page page2 = PageHelper.startPage(1, 3, true);
        after_saleMapper.week();
        counts.add(page2.getTotal());

        Page page3 = PageHelper.startPage(1, 3, true);
        after_saleMapper.lastWeek();
        counts.add(page3.getTotal());

        Page page4 = PageHelper.startPage(1, 3, true);
        after_saleMapper.month();
        counts.add(page4.getTotal());

        Page page5 = PageHelper.startPage(1, 3, true);
        after_saleMapper.lastMonth();
        counts.add(page5.getTotal());

        Page page6 = PageHelper.startPage(1, 3, true);
        after_saleMapper.quarter();
        counts.add(page6.getTotal());

        Page page7 = PageHelper.startPage(1, 3, true);
        after_saleMapper.lastQuarter();
        counts.add(page7.getTotal());
        return counts;
    }

    /**
     * 根据id 查询业务实体类 售后
     * @param id
     * @return
     */
    public After_sale_bo queryById(String id){
        return after_saleMapper.queryById(id);
    }
}
