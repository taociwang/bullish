package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.crm.entity.*;
import com.hy.crm.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Authorization {
    @Autowired
    private AuthorityServiceImpl authorization;
    @Autowired
    private UserroleServiceImpl userRole;
    @Autowired
    private RoleServiceImpl role;
    @Autowired
    private UserServiceImpl user;
    @Autowired
    private RoleauthorityServiceImpl roleauthority;

    @RequestMapping("/role.do")
    public String roleselect(String id, Model model){
        User userbyid=user.getById(id);
        List<Userrole> userRoleList=userRole.list(new QueryWrapper<Userrole>().eq("userid",id));
        QueryWrapper wrapper=new QueryWrapper();
        List<Role> roles=role.list(wrapper);
        model.addAttribute("userbyid",userbyid);
        model.addAttribute("userrolelist",userRoleList);
        model.addAttribute("roles",roles);
        return "ramiss.html";
    }
    @RequestMapping("/roleper.do")
    @ResponseBody
    public LayUI roleper(@RequestParam(value = "page") Integer currentPage, @RequestParam(value = "limit") Integer pageseiz){
        Page pages = PageHelper.startPage(currentPage,pageseiz);
        QueryWrapper<Role> wrapper=new QueryWrapper<>();
        List<Role> list=role.list(wrapper);
        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        Long total=pageInfo.getTotal();
        LayUI layui=new LayUI();
        layui.setCode(0);
        layui.setMag("数据返回正常");
        layui.setCount(total.intValue());
        layui.setData(list);
        return layui;
    }


    @RequestMapping("/rolepermissionp.do")
    public String rolepermissionp(Roleauthority roleautho){
        roleauthority.remove(new UpdateWrapper<Roleauthority>().eq("roleid",roleautho.getRoleid()));
        for(int i=0;i<roleautho.getRoleauth().length;i++){
            Roleauthority per=new Roleauthority();
            per.setRoleid(roleautho.getRoleid());
            per.setAuthorityid((roleautho.getRoleauth()[i]));
            //System.out.println(rolePer.getPerid());
            roleauthority.save(per);
        }
        return "Roleauthority.html";
    }
}
