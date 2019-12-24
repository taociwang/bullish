package com.hy.crm.controller;


import com.hy.crm.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/crm/user")
public class UserController {

    /**
     * 登入
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public int login(User user, HttpServletRequest request){
        //将用户名存入shiro usernamePasswordToken;
        request.getSession().setAttribute("user",user);
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

    /**
     * 退出登录
     */
    @RequestMapping("/outLogin.do")
    public String outLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login.html";
    }
}
