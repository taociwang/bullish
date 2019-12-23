package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Business;
import com.hy.crm.mapper.UserAndBusinessMapper;
import com.hy.crm.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAndBusinessServicelmpl {
    @Autowired
    private UserAndBusinessMapper userAndBusinessMapper;
    @Autowired
    private UserServiceImpl userService;
    public IPage<Business> queryUserbus(Integer pagenum,Integer limit,Business business,String id){
        Page<Business> p = new Page<Business>(pagenum,limit);
        p.setRecords(userAndBusinessMapper.queryUserbus(business,userService.getCurrUid(),p));
        return p;
    }
}
