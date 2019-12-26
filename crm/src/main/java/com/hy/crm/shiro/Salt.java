package com.hy.crm.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Salt {
    public String yan(String upwd,String uname){
        String hashAlgorithmName = "MD5";//加密方式
        Object credentials = upwd;//要加密的密码
        Object salt = ByteSource.Util.bytes(uname);//加的盐
        int hashIterations = 1000;//加密次数

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        return result.toString();
    }

}
