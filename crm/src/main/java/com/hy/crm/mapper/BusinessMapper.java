package com.hy.crm.mapper;

import com.hy.crm.bo.StatisticsBo;
import com.hy.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface BusinessMapper extends BaseMapper<Business> {


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

}
