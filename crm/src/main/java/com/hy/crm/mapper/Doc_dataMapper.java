package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.Doc_Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface Doc_dataMapper extends BaseMapper<Doc_Data> {
    @Results({
            @Result(column = "type_name" ,property = "data.type_name")
    })
    @Select("select d.*,dd.type_name from documentary d,data dd where d.deId=dd.typeid")
    public List<Doc_Data> qureydd();
}
