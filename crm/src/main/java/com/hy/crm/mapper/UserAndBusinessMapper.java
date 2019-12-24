package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.UserAndBusiness;
import com.hy.crm.mapperSql.StudentSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserAndBusinessMapper extends BaseMapper<UserAndBusiness> {
    @Results({
            @Result(column = "type_name",property = "data.type_name")
    })
    @SelectProvider(type = StudentSql.class,method = "MyBusAll")
    public List<Business> queryUserbus(Business business, String id, IPage page);
}
