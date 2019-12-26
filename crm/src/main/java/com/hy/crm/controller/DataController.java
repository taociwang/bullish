package com.hy.crm.controller;


import com.hy.crm.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Data;
import com.hy.crm.entity.LayUI;
import com.hy.crm.service.IDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 基本数据管理表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/crm/data")
public class DataController {
    @Autowired
    private DataServiceImpl dataService;
    @RequestMapping(value = "/toadd.do")
    public String toadd(Model model){
        model.addAttribute("datalist",dataService.queryData());
        return "clien/add";
    }


    @Autowired
    private IDataService iDatetypeService;

    /**
     * 查询
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/dateTypeList.do")
    public LayUI dateTypeList(Integer page, Integer limit) {
        Page<Data> page1 = new Page<>(page,limit);
        IPage<Data> iPage = iDatetypeService.page(page1,new QueryWrapper<Data>());
        LayUI layui = new LayUI();
        layui.setCode(0);
        layui.setMag("");
        Long l = iPage.getTotal();
        layui.setCount(l.intValue());
        layui.setData(iPage.getRecords());
        return layui;

    }
    /**
     * 添加
     *
     * @param
     * @param //client
     * @return
     */
    @PostMapping("/addDateType.do")
    @ResponseBody
    public String addDateType(Data datetype) {
        String is = "1";
        try {
            iDatetypeService.save(datetype);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }

    /**
     * 去修改
     * @param did
     * @return
     */
    @RequestMapping("/toUpdateDateTypeList.do")
    public ModelAndView toUpdateDateTypeList(Integer did) {
        System.out.println(did);
        ModelAndView modelAndView = new ModelAndView();
        Data datetype  = iDatetypeService.getById(did);
        modelAndView.addObject("datetype", datetype);
        modelAndView.setViewName("data/update.html");
        return modelAndView;
    }

    /**
     * 修改
     * @param datetype
     * @return
     */
    @RequestMapping("/updateDateType.do")
    @ResponseBody
    public String updateDateType(Data datetype) {
        String is = "1";
        try {
            iDatetypeService.updateById(datetype);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }

    /**
     * 删除
     * @param did
     * @return
     */
    @RequestMapping("/deleteDateType.do")
    @ResponseBody
    public String deleteDateType(Integer did) {
        String is = "1";
        try {
            iDatetypeService.removeById(did);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }

}
