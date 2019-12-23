package com.hy.crm.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;
import com.hy.crm.entity.Data;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClienServiceImpl;
import com.hy.crm.service.impl.DataServiceImpl;
import com.hy.crm.service.impl.UserAndBusinessServicelmpl;
import com.hy.crm.util.LayuiData;
import com.hy.crm.util.LayuiDatabus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商机表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/crm/business")
public class BusinessController {

    @Autowired
    private BusinessServiceImpl businessService;
    @Autowired
    private DataServiceImpl dataService;
    @Autowired
    private ClienServiceImpl clienService;
    @Autowired
    private UserAndBusinessServicelmpl userAndBusinessServicelmpl;
    @RequestMapping("/queryAllbus.do")
    @ResponseBody
    public LayuiDatabus queryAllbus(Business business, Integer page, Integer limit){
        /*Page page1 = PageHelper.startPage(page , limit);*/
        LayuiDatabus layuiDatabus = new LayuiDatabus();
        /*List<Business> businesses = businessService.queryBusin(business.getBname(),business.getSyzt(),business.getPredictsum(),business.getFzr(),business.getSjssbm(),business.getDate());*/
        IPage<Business> iPage = businessService.queryBusin(page,limit,business.getBname(),business.getSyzt(),business.getPredictsum(),business.getFzr(),business.getSjssbm(),business.getDate());
        /*PageInfo<Business> pageInfo = new PageInfo<>(businesses);*/
        layuiDatabus.setCode(0);
        layuiDatabus.setMsg("");
        /*Long l = pageInfo.getTotal();*/
        Long l = iPage.getTotal();
        layuiDatabus.setCount(l.intValue());
        /*layuiDatabus.setData(businesses);*/
        layuiDatabus.setData(iPage.getRecords());
        System.out.println(layuiDatabus);
        return layuiDatabus;
    }

    /**
     * 查询我的商机
     *
     * @param
     * @return
     */
    @RequestMapping("/MyBusAll.do")
    @ResponseBody
    public LayuiDatabus MyBusAll(Integer page, Integer limit, Business business ,String id) {
        LayuiDatabus layuiDatabus = new LayuiDatabus();
        IPage<Business> iPage = userAndBusinessServicelmpl.queryUserbus(page,limit,business,id);
        layuiDatabus.setCode(0);
        layuiDatabus.setMsg("");
        Long l = iPage.getTotal();
        layuiDatabus.setCount(l.intValue());
        layuiDatabus.setData(iPage.getRecords());
        return layuiDatabus;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Business business){
        System.out.println(business.toString());
        businessService.save(business);
        return "redirect:/business/business.html";
    }


    /**
     * 去添加
     */
    @RequestMapping(value = "/toadd.do")
    public String toadd(Model model,Clien clien,Integer cid){
        //客户类型
        model.addAttribute("da",dataService.list(new QueryWrapper<Data>().eq("typeid",1)));
        //客户来源
        model.addAttribute("da1",dataService.list(new QueryWrapper<Data>().eq("typeid",207)));
        //所属行业
        model.addAttribute("da2",dataService.list(new QueryWrapper<Data>().eq("typeid",607)));
        //获取部门
        model.addAttribute("bmlist",dataService.list(new QueryWrapper<Data>().eq("typeid",1003)));

        model.addAttribute("clienlist",clienService.list(null));
        return "business/businessadd";
    }

    /*
    * 去修改商机
    * */
    @RequestMapping("/toupdatebus.do")
    public String toupdatebus(Model model, Integer bid){
        //客户来源
        model.addAttribute("customerSourceList",dataService.list(new QueryWrapper<Data>().eq("typeid",207)));
        //所属行业
        model.addAttribute("categoryList",dataService.list(new QueryWrapper<Data>().eq("typeid",3)));
        //获取部门
        model.addAttribute("bmlist",dataService.list(new QueryWrapper<Data>().eq("typeid",1003)));
        model.addAttribute("buslist",businessService.getById(bid));
        return "business/businessupdate";
    }


    //修改商机
    @RequestMapping("/updatebus.do")
    public String updatebus(Business business){
        businessService.saveOrUpdate(business);
        return "redirect:/business/business.html";
    }
    @RequestMapping("/clien.do")
    @ResponseBody
    public Clien queryClien(String cid){
        return clienService.getById(cid);

    }




}
