package com.hy.crm.mapper;

import com.hy.crm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

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

}
