package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.crm.bo.ClienBo;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;
import com.hy.crm.entity.Data;
import com.hy.crm.service.impl.ClienBoService;
import com.hy.crm.service.impl.ClienServiceImpl;
import com.hy.crm.service.impl.DataServiceImpl;
import com.hy.crm.util.LayuiData;
import com.hy.crm.util.LayuiDataBo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/clien")
public class ClienController {
    @Autowired
    private ClienServiceImpl clienService;
    @Autowired
    private DataServiceImpl dataService;
    @Autowired
    private ClienBoService clienBoService;
    /*
     * 查询
     * */
/*    @RequestMapping("/queryAll.do")
    @ResponseBody
    public LayuiData queryAll( Clien clien, Integer page, Integer limit){
        Page page1 = PageHelper.startPage(page ,limit);
        List<Clien> cliens= clienService.queryCli(clien.getUname());
        PageInfo<Clien> pageInfo = new PageInfo<>(cliens);
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l = pageInfo.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(cliens);
        System.out.println(layuiData);
        return layuiData;
    }*/
    @RequestMapping("/queryAllbo.do")
    @ResponseBody
    public LayuiDataBo queryAllbo(Integer page, Integer limit, String type, String value, String typeid){
        IPage iPage = new Page(page,limit);
        List<ClienBo> list = clienBoService.list(iPage,value,type,typeid);
        //PageInfo<ClienBo> pageInfo = new PageInfo<>(list);
        iPage.setRecords(list);
        LayuiDataBo layuiDataBo = new LayuiDataBo();
        layuiDataBo.setCode(0);
        layuiDataBo.setMsg("");
        Long l = iPage.getTotal();
        layuiDataBo.setCount(list.size());
        layuiDataBo.setData(list);
        return layuiDataBo;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Clien clien){
        System.out.println(clien.toString());
        clienService.save(clien);
        return "redirect:/clien/clien.html";
    }

    /**
     * 去添加
     */
    @RequestMapping(value = "/toadd.do")
    public String toadd(Model model){
        model.addAttribute("da",dataService.list(new QueryWrapper<Data>().eq("typeid",1)));
        model.addAttribute("da1",dataService.list(new QueryWrapper<Data>().eq("typeid",209)));
        model.addAttribute("da2",dataService.list(new QueryWrapper<Data>().eq("typeid",607)));
        return "clien/clienadd";
    }


    /*
     * 去修改客户
     * */
    @RequestMapping("/toupdatecli.do")
    public String toupdatecli(Model model, Integer cid){
        model.addAttribute("typeidlist",dataService.list(new QueryWrapper<Data>().eq("typeid",1)));
        //客户来源
        model.addAttribute("customerSourceList",dataService.list(new QueryWrapper<Data>().eq("typeid",209)));
        //所属行业
        model.addAttribute("categoryList",dataService.list(new QueryWrapper<Data>().eq("typeid",607)));
        //获取部门
        model.addAttribute("bmlist",dataService.list(new QueryWrapper<Data>().eq("typeid",1003)));
        model.addAttribute("clilist",clienService.getById(cid));
        model.addAttribute("clien",clienService.list(null));
        return "clien/clienupdate";
    }


    //修改客户
    @RequestMapping("/updatecli.do")
    @ResponseBody
    public String updatecli(Clien clien){
        clienService.saveOrUpdate(clien);
        return "clien/clien";
    }

}
