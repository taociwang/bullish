package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.ClienBo;
import com.hy.crm.entity.Clien;
import com.hy.crm.mapperSql.StudentSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface ClienBoMapper extends BaseMapper<ClienBo>{

    @Select("SELECT COUNT(*) FROM contract c WHERE c.docid IN (SELECT d.docid FROM documentary d " +
            "WHERE d.busid IN (SELECT b.bid FROM business b WHERE b.clienid=#{cid}))")
    public Integer count(Integer cid);

    @Select("SELECT sum(c.remittance) FROM contract c WHERE c.docid IN (SELECT d.docid FROM documentary d " +
            "WHERE d.busid IN (SELECT b.bid FROM business b WHERE b.clienid=#{clid}))")
    public Integer sum(Integer cid);

    @SelectProvider(type = StudentSql.class,method = "query")
    public List<Clien> queryCli(String value, String type,IPage iPage);
    @SelectProvider(type = StudentSql.class,method = "querynoe")
    public  List<Clien> querynoe(String typeid,IPage iPage);




}
