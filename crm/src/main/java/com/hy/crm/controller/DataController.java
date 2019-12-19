package com.hy.crm.controller;


import com.hy.crm.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}
