package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Contract;
import com.hy.crm.mapper.ContractMapper;
import com.hy.crm.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 合同表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Autowired
    private ContractMapper contractMapper;

    /*模糊查询合同*/
    public List<Contract> queryAllContract(Contract contract,String type,String text,String state,String contract_date){
        return contractMapper.queryAllContract(type,contract,text,state,contract_date);
    }

    public List<Contract> queryAllContract1(Contract contract,String type,String text,String contract_date){
        return contractMapper.queryAllContract1(type,contract,text,contract_date);
    }

}
