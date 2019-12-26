package com.hy.crm.mapper;

import com.hy.crm.bo.StatisticsBo;
import com.hy.crm.bo.TypeStatisticsBo;
import com.hy.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.hy.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Clien;
import com.hy.crm.mapperSql.StudentSql;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import org.apache.ibatis.annotations.Select;

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
    /*
     * 全部商机查询
     * */
   @Results({
          @Result(column = "type_name",property = "data.type_name")
   })
    @SelectProvider(type = StudentSql.class,method = "select")
    public List<Business> queryBus (String bname, String syzt,Integer predictsum,  String fzr, String sjssbm , String time,IPage page );

   /*
   * 查询商机状态
   * */
   @Select("select * from business where syzt=#{syzt}")
   List<Business> querysyzt(String syzt);
    //public List<Business> queryBus (@Param("bname") String bname, @Param("syzt") String syzt, @Param("predictsum") Integer predictsum, @Param("fzr") String fzr, @Param("sjssbm")String sjssbm , @Param("time") String time,IPage page );



    /**
     * 本周
     */
    @Select("SELECT count(*) FROM Business WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)")
    public Integer week();
    @Select("SELECT u.username count(*) count FROM Business b,user u WHERE b.userid=u.id and yearweek(date_format(b.date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) group by b.userid")
    public List<StatisticsBo> week_g();
    @Select("SELECT count(*) FROM Business WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and userid=#{userid}")
    public Integer weekByUId(String userid);

    /**
     * 上周
     */
    @Select("SELECT count(*) FROM Business WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1")
    public Integer lastWeek();
    @Select("SELECT u.username count(*) count FROM Business b,user u WHERE b.userid=u.id and yearweek(date_format(b.date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 group by b.userid")
    public List<StatisticsBo> lastWeek_g();
    @Select("SELECT count(*) FROM Business WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and userid=#{userid}")
    public Integer lastWeekByUserid(String userid);

    /**
     * 本月
     */
    @Select("SELECT count(*) FROM Business WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public Integer month();
    @Select("SELECT u.username count(*) count FROM Business b,user u WHERE b.userid=u.id and DATE_FORMAT( b.date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) group by b.userid")
    public List<StatisticsBo> month_g();
    @Select("SELECT count(*) FROM Business WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and userid=#{userid}")
    public Integer monthByUserid(String userid);

    /**
     * 上月
     */
    @Select("SELECT count(*) FROM Business WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1")
    public Integer lastMonth();
    @Select("SELECT u.username count(*) count FROM Business b,user u WHERE b.userid=u.id and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( b.date, '%Y%m' ) ) =1 group by b.userid")
    public List<StatisticsBo> lastMonth_g();
    @Select("SELECT count(*) FROM Business WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1 and userid=#{userid}")
    public Integer lastMonthByUserid(String userid);

    /**
     * 本季度
     */
    @Select("SELECT count(*) from Business where QUARTER(date)=QUARTER(now())")
    public Integer quarter();
    @Select("SELECT u.username count(*) count FROM Business b,user u WHERE b.userid=u.id and QUARTER(b.date)=QUARTER(now()) group by b.userid")
    public List<StatisticsBo> quarter_g();
    @Select("SELECT count(*) from Business where QUARTER(date)=QUARTER(now()) and userid=#{userid}")
    public Integer quarterByUserid(String userid);

    /**
     * 上季度
     */
    @Select("SELECT count(*) from Business where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))")
    public Integer lastQuarter();
    @Select("SELECT u.username count(*) count FROM Business b,user u WHERE b.userid=u.id and QUARTER(b.date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) group by b.userid")
    public List<StatisticsBo> lastQuarter_g();
    @Select("SELECT count(*) from Business where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and userid=#{userid}")
    public Integer lastQuarterByUserid(String userid);

    /**
     * 漏斗 所有
     */
    @Select("SELECT * from (select d.type_name  typeName ,count(b.bid) count,IFNULL(sum(b.predictsum),0) sum from data d LEFT JOIN business b on b.syzt=d.did  GROUP BY b.syzt) a order by a.count")
    public List<TypeStatisticsBo> funnel();
    @Select("select count(*) count,sum(predictsum) sum from business")
    public TypeStatisticsBo funnelCount();

    /**
     * 漏斗 本年度
     */
    @Select("SELECT * from (select d.type_name  typeName ,count(b.bid) count,IFNULL(sum(b.predictsum),0) sum from data d LEFT JOIN business b on b.syzt=d.did where typeid=4 and YEAR(b.date) = YEAR(now()) GROUP BY b.syzt) a order by a.count")
    public List<TypeStatisticsBo> yearFunnel();
    @Select("select count(*) count,sum(predictsum) sum from business where YEAR(date) = YEAR(now())")
    public TypeStatisticsBo yearFunnelCount();

    /**
     * 漏斗 上年度
     */
    @Select("SELECT * from (select d.type_name  typeName ,count(b.bid) count,IFNULL(sum(b.predictsum),0) sum from data d LEFT JOIN business b on b.syzt=d.did where typeid=4 and YEAR(b.date) = YEAR(now())-1 GROUP BY b.syzt) a order by a.count")
    public List<TypeStatisticsBo> lastYearFunnel();
    @Select("select count(*) count ,sum(predictsum) sum from business where YEAR(date) = YEAR(now())-1")
    public TypeStatisticsBo lastYearFunnelCount();

    /**
     * 漏斗 本季度
     */
    @Select("SELECT * from (select d.type_name  typeName ,count(b.bid) count,IFNULL(sum(b.predictsum),0) sum from data d LEFT JOIN business b on b.syzt=d.did where typeid=4 and YEAR(b.date) = YEAR(now()) GROUP BY b.syzt) a order by a.count")
    public List<TypeStatisticsBo> quarterFunnel();
    @Select("select count(*) count ,sum(predictsum) sum from business where YEAR(date) = YEAR(now())")
    public TypeStatisticsBo quarterFunnelCount();

    /**
     * 漏斗 上季度
     */
    @Select("SELECT * from (select d.type_name  typeName ,count(b.bid) count,IFNULL(sum(b.predictsum),0) sum from data d LEFT JOIN business b on b.syzt=d.did where typeid=4 and YEAR(b.date) = YEAR(now())-1 GROUP BY b.syzt) a order by a.count")
    public List<TypeStatisticsBo> lastQuarterFunnel();
    @Select("select count(*) count,sum(predictsum) sum from business where YEAR(date) = YEAR(now())-1")
    public TypeStatisticsBo lastQuarterFunnelCount();

}
