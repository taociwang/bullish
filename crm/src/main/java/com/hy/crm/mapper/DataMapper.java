package com.hy.crm.mapper;

import com.hy.crm.entity.Data;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 基本数据管理表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Mapper
public interface DataMapper extends BaseMapper<Data> {
    //查询所有班级
    @Select("select * from data")
    public List<Data> queryData();

}
