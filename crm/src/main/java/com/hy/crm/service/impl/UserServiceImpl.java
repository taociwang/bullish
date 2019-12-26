package com.hy.crm.service.impl;

import com.hy.crm.entity.User;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hy.crm.shiro.Salt;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    private void updateuser(String username) {
        userMapper.updateuser(username);
    }


    /**
     * 根据登录的用户名获取用户id
     * @return
     */
    public String getCurrUid() {
        return userMapper.getUidByUsername((String) SecurityUtils.getSubject().getPrincipal());
    }
    /*
    * 根据id获取所有的用户信息
    * */
    public User getUserById(Integer uid){
        return userMapper.getUserByid(uid);
    }

    /**
     * 根据登陆的用户名获取当前用户
     * @return
     */
    public User getCurrUser() {
        return userMapper.getUserByname((String) SecurityUtils.getSubject().getPrincipal());
    }
    /*
    * 注册用户
    * */
    public boolean add(User user){
        int jj = userMapper.insert(user);
        boolean jojo;
        if(jj>0){
            jojo = true;
        }else {
            jojo = false;
        }

        return jojo;
    }
    /*
    *
    * 获取用户名称
    * */
    public Integer getIdByName(String username){
        return userMapper.getIdByName(username);
    }
    /**
     * 修改密码
     * @param newmm
     * @param uid
     * @param lod
     * @param uname
     * @return
     */
    public boolean xiu(String newmm,Integer uid,String uname){
        Salt jia=new Salt();
        String xin=jia.yan(newmm,uname);
        boolean b=userMapper.updateusername(xin,uid);
        return b;
    }

    /**
     * 查询密码
     * @param upwd
     * @param uname
     * @return
     */
    public boolean cha(String upwd,String uname){
        System.out.println("==="+upwd+"||"+uname);
        Salt jia=new Salt();
        String mm=jia.yan(upwd,uname);//给密码加盐
        User user=userMapper.querypass(uname,mm);//mm拿到密码，ua String类型是用户参数吗？
        boolean b;
        if(user!=null){
            b=true;
        }else {
            b=false;
        }
        return b;
    }
}



