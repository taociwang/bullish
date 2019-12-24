package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Documentary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Doc_busMapper extends BaseMapper<Documentary> {
    @Select("select bid,bname from business")
    public List<Business> queryBus();
    @Select("select * from documentary where busid=#{vlue}")
    public List<Documentary> querySj(Integer busid);
}
