package com.hy.crm.mapper;


import com.github.pagehelper.Page;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clien;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.mapperSql.StudentSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Mapper
public interface ClienMapper extends BaseMapper<Clien> {
    @Select("select c.uname,data.gname from clien s left join data g on s.typeid=g.typeid")
    public List<Clien> queryall();

/*    @SelectProvider(type = StudentSql.class,method = "query")
    public List<Clien> queryCli(String uname);*/

    @Select("SELECT COUNT(*) FROM contract c ,`clien` cl WHERE c.`clienid`=cl.`cid` AND c.`clienid` = #{cid}")
    public Integer count(Integer cid);




}
