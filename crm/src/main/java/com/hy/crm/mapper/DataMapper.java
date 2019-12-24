package com.hy.crm.mapper;

import com.hy.crm.bo.TypeStatisticsBo;
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

    /**
     * 根据客户行业分布 统计成交数、成交总金额
     */
    @Select("select  d.type_name typeName, count(*) count ,sum(con.contract_money) sum  from clien c,contract con ,data d where  con.clienid=c.cid and d.did=c.sshy GROUP BY c.sshy")
    public List<TypeStatisticsBo> industryStatistics();

    /**
     * 根据客户来源 统计成交数、成交总金额
     * @return
     */
    @Select("select d.type_name typeName, count(*) count ,sum(con.contract_money) sum  from clien c,contract con ,data d where  con.clienid=c.cid and d.did=c.khly GROUP BY c.khly")
    public List<TypeStatisticsBo> sourecStatistics();
}
