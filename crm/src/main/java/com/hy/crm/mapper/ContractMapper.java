package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Clien;
import com.hy.crm.entity.Contract;
import com.hy.crm.sql.ContractSQL;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 合同表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public interface ContractMapper extends BaseMapper<Contract> {




    /**
     * 本周
     */
    @Select("SELECT count(*) FROM contract WHERE yearweek(date_format(contract_date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)")
    public Integer week();
    @Select("SELECT count(*) FROM contract WHERE yearweek(date_format(contract_date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) group by userid")
    public Integer week_g();
    @Select("SELECT count(*) FROM contract WHERE yearweek(date_format(contract_date,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and userid=#{userid}")
    public Integer weekByUserid(String userid);

    /**
     * 上周
     */
    @Select("SELECT count(*) FROM contract WHERE yearweek(date_format(contract_date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1")
    public Integer lastWeek();
    @Select("SELECT count(*) FROM contract WHERE yearweek(date_format(contract_date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 group by userid")
    public Integer lastWeek_g();
    @Select("SELECT count(*) FROM contract WHERE yearweek(date_format(contract_date,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and userid=#{userid}")
    public Integer lastWeekByUserid(String userid);

    /**
     * 本月
     */
    @Select("SELECT count(*) FROM contract WHERE DATE_FORMAT( contract_date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public Integer month();
    @Select("SELECT count(*) FROM contract WHERE DATE_FORMAT( contract_date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) group by userid")
    public Integer month_g();
    @Select("SELECT count(*) FROM contract WHERE DATE_FORMAT( contract_date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and userid=#{userid}")
    public Integer monthByUserid(String userid);

    /**
     * 上月
     */
    @Select("SELECT count(*) FROM contract WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( contract_date, '%Y%m' ) ) =1")
    public Integer lastMonth();
    @Select("SELECT count(*) FROM contract WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( contract_date, '%Y%m' ) ) =1 group by userid")
    public Integer lastMonth_g();
    @Select("SELECT count(*) FROM contract WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( contract_date, '%Y%m' ) ) =1 and userid=#{userid}")
    public Integer lastMonthByUserid(String userid);

    /**
     * 本季度
     */
    @Select("SELECT count(*) from contract where QUARTER(contract_date)=QUARTER(now())")
    public Integer quarter();
    @Select("SELECT count(*) from contract where QUARTER(contract_date)=QUARTER(now()) group by userid")
    public Integer quarter_g();
    @Select("SELECT count(*) from contract where QUARTER(contract_date)=QUARTER(now()) and userid=#{userid}")
    public Integer quarterByUserid(String userid);

    /**
     * 上季度
     */
    @Select("SELECT count(*) from contract where QUARTER(contract_date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))")
    public Integer lastQuarter();
    @Select("SELECT count(*) from contract where QUARTER(contract_date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) group by userid")
    public Integer lastQuarter_g();
    @Select("SELECT count(*) from contract where QUARTER(contract_date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and userid=#{userid}")
    public Integer lastQuarterByUserid(String userid);


    /*模糊查询查询论坛*/
    @SelectProvider(type = ContractSQL.class,method = "queryAllContract")
    List<Contract> queryAllContract(String type, Contract contract , String text,String state,String contract_date);

    @SelectProvider(type = ContractSQL.class,method = "queryAllContract1")
    List<Contract> queryAllContract1(String type, Contract contract , String text,String contract_date);

    @Select("select * from clien")
    List<Clien> getname();
}
