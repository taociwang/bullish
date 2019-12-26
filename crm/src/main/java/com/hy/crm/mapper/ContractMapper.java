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

    /*模糊查询查询论坛*/
    @SelectProvider(type = ContractSQL.class,method = "queryAllContract")
    List<Contract> queryAllContract(String type, Contract contract , String text,String state,String contract_date);

    @SelectProvider(type = ContractSQL.class,method = "queryAllContract1")
    List<Contract> queryAllContract1(String type, Contract contract , String text,String contract_date);

    @Select("select * from clien")
    List<Clien> getname();
}
