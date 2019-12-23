package com.hy.crm.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.hy.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Clien;
import com.hy.crm.mapperSql.StudentSql;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import java.util.List;

/**
 * <p>
 * 商机表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    /*@Select("select count(*) from business where bid=#{bid}")
    public List<Business> queryid();*/

    /*public List<Business> queryBus(String bname,String syzt,Integer predictsum,String fzr,String sjssbm,String time);*/
    /*, @Param("bname") String bname, @Param("syzt") String syzt, @Param("predictsum") Integer predictsum, @Param("fzr") String fzr, @Param("sjssbm")String sjssbm , @Param("time") String time*/
    //根据商机外键clienid查询客户信息

    @Select("SELECT c.`uname`,c.`sshy`,c.`shi`,c.site FROM business b LEFT JOIN clien c ON b.clienid = c.cid WHERE clienid=#{cid}")
    public List<Business> queryClien(Integer cid);
 /*   @Select("select * from clien ")
    public List<Clien> getname(String uname);*/
    @Select("SELECT COUNT(*) FROM business b WHERE b.clienid=#{cid}")
    public Integer count(Integer cid);

    @Select("SELECT sum(b.predictsum) FROM business b WHERE b.clienid=#{cid}")
    public Integer sum(Integer cid);


    @SelectProvider(type = StudentSql.class,method = "select")
    public List<Business> queryBus (String bname, String syzt,Integer predictsum,  String fzr, String sjssbm , String time,IPage page );

    //public List<Business> queryBus (@Param("bname") String bname, @Param("syzt") String syzt, @Param("predictsum") Integer predictsum, @Param("fzr") String fzr, @Param("sjssbm")String sjssbm , @Param("time") String time,IPage page );


}
