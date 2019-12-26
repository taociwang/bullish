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
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        //根据用户的情况构建 SimpleAuthenticationInfo 并返回
        //以下的数据是从数据库获取的
        Object uname = user.getUsername();
        Object upwd = user.getPassword();

        ByteSource salt = ByteSource.Util.bytes(username);
        //返回认证信息由父类 AuthenticatingRealm 进行认证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(uname, upwd, salt, getName());
        return info;
    }

}
