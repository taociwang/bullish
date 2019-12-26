package com.hy.crm.service.impl;

import com.hy.crm.entity.User;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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

    /*
    * 测试
    * */
    /*public void changePasswordById(Integer uid,String old_password,String new_password){
        //1、根据用户id查询到用户的信息
        User user=getUserById(uid);
        //2、将用户输入的密码加密
        if(user!=null){
            String salt=user.getPassword();
        //获取加密前的盐值
         String md5password=getEncrptedPassword(old_password,salt);
         //3、将用户输入加密后的密码与数据库的密码进行匹配
        if(user.getPassword.equals(md5password)){
        //4、匹配成功，则修改密码，匹配失败，则抛出异常
        System.out.println("原密码正确...");
         String md5newpassword=getEncrptedPassword(new_password,salt);
        changePassword(uid,md5newpassword);
        //调用修改密码方法
        }else{
            throw new PasswordNotMatchException("原密码不正确！"); }
        }else{
            throw new UserNotFoundException("用户名未找到！"); }
        }*/
        /*private void changePassword(Integer uid,String md5newpassword) throws UpdateDataException{
        //调用持久层，实现密码修改
        System.out.println("newpassword:"+md5newpassword);
        Integer row=userMapper.changePassword(md5newpassword,uid);
        //由于是根据用户id来进行修改的，正确操作下，受影响的行数应该为1
        if(row!=1){
            throw new UpdateDataException("修改密码时发现未知错误！请联系管理员！");
        }
    }*/
}



