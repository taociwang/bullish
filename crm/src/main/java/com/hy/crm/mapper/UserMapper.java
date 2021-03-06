package com.hy.crm.mapper;

import com.hy.crm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public interface UserMapper extends BaseMapper<User> {


    @Select("update user set password=#{password} where username=#{username}")
    public void  updateuser(String username);
    @Select("select * from user where id=#{id}")
    public User getUserByid(Integer id);
    @Select("select * from user where username = #{username}")
    public User getUserByname(String username);
    @Select("select id from user where username = #{username}")
    String getUidByUsername(String username);
    @Select("insert into user(username,password) values(#{username},#{password})")
    Integer insert_user(User user);
    @Select("select id from user where username=#{value}")
    Integer getIdByName(String username);
    Integer changePassword(@Param("password") String password,@Param("id") Integer uid);
    //修改密码
    @Update("update user set password=#{newmm}  where id=#{uid}")
    boolean updateusername(@Param("newmm") String newmm,@Param("uid") Integer uid);
    //查询密码
    @Select("select * from user where username=#{username} and password=#{password}")
    User querypass(@Param("username") String username,@Param("password") String password);

}
