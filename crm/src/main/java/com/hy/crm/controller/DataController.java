package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Data;
import com.hy.crm.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/query.do")
    public List<Data> query() {
        return dataService.list(new QueryWrapper<Data>().eq("typeid",607));
    }
}
