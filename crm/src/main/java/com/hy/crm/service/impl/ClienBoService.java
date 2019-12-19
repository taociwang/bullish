package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.ClienBo;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.mapper.ClienBoMapper;
import com.hy.crm.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ClienBoService extends ServiceImpl<ClienBoMapper, ClienBo> {
    @Autowired
    private ClienServiceImpl clienService;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ClienBoMapper clienBoMapper;
     public List<ClienBo> list(String value, String type, String typeid){

         //拿到所有客户
         List<Clien> clienlist=clienService.queryCli(value, type, typeid);
         //new客户的Bo
         List<ClienBo> clienBos=new ArrayList<>();
         for(Clien clien:clienlist){
             ClienBo clienBo=new ClienBo();
             //拿到客户的id和name
             clienBo.setCid(clien.getCid());
             clienBo.setUname(clien.getUname());
             //拿到商机的count和sum
             clienBo.setBcount(businessMapper.count(clien.getCid()));
             clienBo.setBsum(businessMapper.sum(clien.getCid()));
             //合同的count和sum
             clienBo.setAcount(clienBoMapper.count(clien.getCid()));
             clienBo.setAsum(clienBoMapper.sum(clien.getCid()));
             //将客户bo的值给到客户Bo的集合里
             clienBos.add(clienBo);
         }
         return clienBos;
     }

}
