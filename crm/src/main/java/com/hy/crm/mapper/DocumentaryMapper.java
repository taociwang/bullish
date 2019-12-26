package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import com.hy.crm.entity.Documentary;

/**
 * <p>
 * 跟单表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public interface DocumentaryMapper extends BaseMapper<Documentary> {
   // @Select("select date,topic,dpeople,particular,accessory from documentary ")
   /* @SelectProvider(type = DocSql.class,method = "queryMy")
    public List<Documentary> queryMy(Documentary documentary, Page<Documentary> page, String kinds, User user);*/




    /**
     * 本周
     */
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)")
    public Integer week();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)  group by userid")
    public Integer week_g();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and userid=#{userid}")
    public Integer weekByUserid(String userid);

    /**
     * 上周
     */
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1")
    public Integer lastWeek();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 group by userid")
    public Integer lastWeek_g();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and userid=#{userid}")
    public Integer lastWeekByUserid(String userid);

    /**
     * 本月
     */
    @Select("SELECT count(*) FROM documentary WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public Integer month();
    @Select("SELECT count(*) FROM documentary WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) group by userid")
    public Integer month_g();
    @Select("SELECT count(*) FROM documentary WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and userid=#{userid}")
    public Integer month(String userid);

    /**
     * 上月
     */
    @Select("SELECT count(*) FROM documentary WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1")
    public Integer lastMonth();
    @Select("SELECT count(*) FROM documentary WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1 group by userid")
    public Integer lastMonth_g();
    @Select("SELECT count(*) FROM documentary WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1 and userid=#{userid}")
    public Integer lastMonth(String userid);

    /**
     * 本季度
     */
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(now())")
    public Integer quarter();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(now()) group by userid")
    public Integer quarter_g();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(now()) and userid=#{userid}")
    public Integer quarter(String userid);

    /**
     * 上季度
     */
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))")
    public Integer lastQuarter();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) group by userid")
    public Integer lastQuarter_g();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and userid=#{userid}")
    public Integer lastQuarter(String userid);


    /**
     *成交数量
     */

    /**
     * 本周
     */
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and stute=1")
    public Integer week1();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and stute=1 group by userid")
    public Integer week1_g();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and stute=1 and userid=#{userid}")
    public Integer week1(String userid);

    /**
     * 上周
     */
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and stute=1")
    public Integer lastWeek1();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and stute=1 group by userid ")
    public Integer lastWeek1_g();
    @Select("SELECT count(*) FROM documentary WHERE yearweek(date_format(date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and stute=1 and userid=#{userid}")
    public Integer lastWeek1(String userid);

    /**
     * 本月
     */
    @Select("SELECT count(*) FROM documentary WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and stute=1")
    public Integer month1();
    @Select("SELECT count(*) FROM documentary WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and stute=1 group by userid")
    public Integer month1_g();
    @Select("SELECT count(*) FROM documentary WHERE DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and stute=1 and userid=#{userid}")
    public Integer month1(String userid);

    /**
     * 上月
     */
    @Select("SELECT count(*) FROM documentary WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1 and stute=1")
    public Integer lastMonth1();
    @Select("SELECT count(*) FROM documentary WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1 and stute=1 group by userid")
    public Integer lastMonth1_g();
    @Select("SELECT count(*) FROM documentary WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( date, '%Y%m' ) ) =1 and stute=1 and userid=#{userid}")
    public Integer lastMonth1(String userid);

    /**
     * 本季度
     */
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(now()) and stute=1")
    public Integer quarter1();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(now()) and stute=1 group by userid")
    public Integer quarter1_g();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(now()) and stute=1 and userid=#{userid}")
    public Integer quarter1(String userid);

    /**
     * 上季度
     */
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and stute=1")
    public Integer lastQuarter1();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and stute=1 group by userid")
    public Integer lastQuarter1_g();
    @Select("SELECT count(*) from documentary where QUARTER(date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and stute=1 and userid=#{userid}")
    public Integer lastQuarter1(String userid);
}
