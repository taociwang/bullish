package com.hy.crm.mapper;

import com.hy.crm.bo.After_sale_bo;
import com.hy.crm.entity.After_sale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 售后 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public interface After_saleMapper extends BaseMapper<After_sale> {
    /**
     * 根据id查询售后详情
     * @param id
     * @return
     */
    @Results({
            @Result(column = "uname", property = "clien.uname"),
            @Result(column = "contract_number", property = "contract.contract_number"),
            @Result(column = "type_name",property = "data.type_name"),
            @Result(column = "e_mail_qq",property = "contract.e_mail_qq")
    })
    @Select("select a.*,c.uname,CO.contract_number,co.e_mail_qq,d.type_name from after_sale a,clien c,contract co,data d where a.clientid=c.cid and a.contractid=co.cid and a.serve_type=d.did and id=#{id}")
    public After_sale_bo queryById(String id);
    /**
     * 本周
     */
    @Select("SELECT * FROM after_sale WHERE yearweek(date_format(state_time,'%Y-%m-%d'),1) = YEARWEEK(now(),1)")
    public List<After_sale> week();

    /**
     * 上周
     */
    @Select("SELECT * FROM after_sale WHERE yearweek(date_format(state_time,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1")
    public List<After_sale> lastWeek();

    /**
     * 本月
     */
    @Select("SELECT * FROM after_sale WHERE DATE_FORMAT( state_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public List<After_sale> month();

    /**
     * 上月
     */
    @Select("SELECT * FROM after_sale WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) ,date_format( state_time, '%Y%m' ) ) =1")
    public List<After_sale> lastMonth();

    /**
     * 本季度
     */
    @Select("select * from after_sale where QUARTER(state_time)=QUARTER(now())")
    public List<After_sale> quarter();

    /**
     * 上季度
     */
    @Select("select * from after_sale where QUARTER(state_time)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))")
    public List<After_sale> lastQuarter();
}
