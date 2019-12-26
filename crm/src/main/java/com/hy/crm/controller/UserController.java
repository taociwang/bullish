package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.User;
import com.hy.crm.service.IUserService;
import com.hy.crm.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 登入
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public int login(User user, HttpServletRequest request){
        //根据用户名称(唯一)查询user
        request.getSession().setAttribute("user",userService.getOne(new QueryWrapper<User>().eq("username",user.getUsername())));
        //将用户名存入shiro usernamePasswordToken;
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //获取主体对象
        Subject subject= SecurityUtils.getSubject();
        int i=1;
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            i=0;
            e.printStackTrace();
        }
        return i;
    }

/*
* 获取用户名
* */
    @RequestMapping("/saveName.do")
    public ModelAndView saveName(String name, HttpServletRequest request){
        ModelAndView view=new ModelAndView();
        User user=userService.getOne(new QueryWrapper<User>().eq("username",name));
        request.getSession().setAttribute("user",user);
        view.setViewName("/1.html");
        return view;
    }
    /*
     * 注册
     * */
    @RequestMapping("/user_add.do")
    @ResponseBody
    public String user_add(User user){
        String hashAlgorithmName = "MD5";//加密方式
        Object credentials = user.getPassword();//要加密的密码
        Object salt = ByteSource.Util.bytes(user.getUsername());//加的盐
        int hashIterations = 1000;//加密次数
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        user.setPassword(result.toString());
        boolean jia = userService.add(user);
        Integer id = userService.getIdByName(user.getUsername());
        /*if (jia){
            System.out.println("============================================================================="+uid);
            *//*Login_Role login_role = new Login_Role();
            login_role.setRid(5);
            login_role.setUid(uid);
            login_roleService.saveOrUpdate(login_role);*//*
        }*/
        return "/login";
    }


    /**
     * 退出登录
     */
    @RequestMapping("/outLogin.do")
    public String outLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login.html";
    }
/*
* 验证用户名是否存在
* */
    @RequestMapping("/username.do")
    @ResponseBody
    public User username(String username){
         return userService.getOne(new QueryWrapper<User>().eq("username",username));
    }


    /**
     * 查询密码对不对
     * @param upwd
     * @return
     */
    @ResponseBody
    @RequestMapping("/cha.do")
    public boolean cha(String upwd,String uname){
        boolean b=userService.cha(upwd,uname);
        return b;
    }

    /**
     * 修改密码
     * @param newmm
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/xiu.do")
    public boolean xiu(String newmm,Integer uid,String uname){
        System.out.println("============="+newmm+"="+uid+"="+uname);
        boolean b=userService.xiu(newmm,uid,uname);
        return b;
    }

    /**
     * 去修改密码
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/toxiu.do")
    public ModelAndView byid(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        //User user=userService.getOne(new QueryWrapper<User>().eq("id",id));
        ModelAndView view=new ModelAndView();
        view.addObject("getUserlist",user);
        view.setViewName("/setuser/user.html");
        return view;
    }
    @RequestMapping("/exit.do")
    public String ss(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.html";
    }
}
