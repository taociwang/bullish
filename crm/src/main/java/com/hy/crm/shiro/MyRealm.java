package com.hy.crm.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.User;
import com.hy.crm.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * Realm 范围
 * 自定义授权认证
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取页面放入token的用户名
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String username=token.getUsername();

        /**
         * 根据用户名查询数据库得到user
         */
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        User user=userService.getOne(queryWrapper);
        if(null==user){
            throw new UnknownAccountException("账号不存在");
        }
        ByteSource salt=ByteSource.Util.bytes(user.getUsername());
        //凭证类 拿到根据token的用户名查到user 用户名密码 和token中的比对(自行)
        AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),salt,getName());
        return authenticationInfo;
    }
}
