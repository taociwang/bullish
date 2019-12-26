package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Zonghe extends BaseMapper {
    @Select("select count(*) from clien ")
    public Integer clien();
    @Select("select count(*) from business")
    public Integer business();
    @Select("select count(*) from contract")
    public Integer contract();
}
