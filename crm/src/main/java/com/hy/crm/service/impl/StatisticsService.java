package com.hy.crm.service.impl;

import com.hy.crm.bo.StatisticsBo;
import com.hy.crm.bo.TypeStatisticsBo;
import com.hy.crm.entity.User;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.mapper.ContractMapper;
import com.hy.crm.mapper.DataMapper;
import com.hy.crm.mapper.DocumentaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计类
 */
@Service
public class StatisticsService {
    @Autowired
    private DocumentaryMapper documentaryMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private DataMapper dataMapper;

    /**
     * 全部统计
     */
    public Map<String,Integer> statistics(){
        Map<String,Integer> map=new HashMap<>();
        //documentary 跟单数
        map.put("doc_week", documentaryMapper.week());
        map.put("doc_last_week", documentaryMapper.lastWeek());
        map.put("doc_month", documentaryMapper.month());
        map.put("doc_last_month", documentaryMapper.lastMonth());
        map.put("doc_quarter", documentaryMapper.quarter());
        map.put("doc_last_quarter", documentaryMapper.lastQuarter());

        //documentary 成功数
        map.put("succ_week", documentaryMapper.week1());
        map.put("succ_last_week", documentaryMapper.lastWeek1());
        map.put("succ_month", documentaryMapper.month1());
        map.put("succ_last_month", documentaryMapper.lastMonth1());
        map.put("succ_quarter", documentaryMapper.quarter1());
        map.put("succ_last_quarter", documentaryMapper.lastQuarter1());

        //business 商机数
        map.put("bus_week", businessMapper.week());
        map.put("bus_last_week", businessMapper.lastWeek());
        map.put("bus_month", businessMapper.month());
        map.put("bus_last_month", businessMapper.lastMonth());
        map.put("bus_quarter", businessMapper.quarter());
        map.put("bus_last_quarter", businessMapper.lastQuarter());

        //contract 合同数
        map.put("con_week", contractMapper.week());
        map.put("con_last_week", contractMapper.lastWeek());
        map.put("con_month", contractMapper.month());
        map.put("con_last_month", contractMapper.lastMonth());
        map.put("con_quarter", contractMapper.quarter());
        map.put("con_last_quarter", contractMapper.lastQuarter());
        return map;
    }

    /**
     * 周统计
     */
    public StatisticsBo week_statistics(User user){
        StatisticsBo statistics=new StatisticsBo();
        statistics.setUsername(user.getUsername());
        String userid=user.getId()+"";
        statistics.setBus_count(businessMapper.weekByUId(userid));
        statistics.setBus_last_coutn(businessMapper.lastWeekByUserid(userid));
        statistics.setCon_count(contractMapper.weekByUserid(userid));
        statistics.setCon_last_coutn(contractMapper.lastWeekByUserid(userid));
        statistics.setDoc_count(documentaryMapper.weekByUserid(userid));
        statistics.setDoc_last_coutn(documentaryMapper.lastWeekByUserid(userid));
        statistics.setSucc_count(documentaryMapper.week1(userid));
        statistics.setSucc_last_coutn(documentaryMapper.lastWeek1(userid));

       return statistics;
    }

    /**
     * 月统计
     */
    public StatisticsBo monthStatistics(User user){
        StatisticsBo statistics=new StatisticsBo();
        statistics.setUsername(user.getUsername());
        String userid=user.getId()+"";
        statistics.setBus_count(businessMapper.monthByUserid(userid));
        statistics.setBus_last_coutn(businessMapper.lastMonthByUserid(userid));
        statistics.setCon_count(contractMapper.monthByUserid(userid));
        statistics.setCon_last_coutn(contractMapper.lastMonthByUserid(userid));
        statistics.setDoc_count(documentaryMapper.month(userid));
        statistics.setDoc_last_coutn(documentaryMapper.lastMonth(userid));
        statistics.setSucc_count(documentaryMapper.month1(userid));
        statistics.setSucc_last_coutn(documentaryMapper.lastMonth1(userid));

        return statistics;
    }

    /**
     * 季度统计
     */
    public StatisticsBo quarterStatistics(User user){
        StatisticsBo statistics=new StatisticsBo();
        statistics.setUsername(user.getUsername());
        String userid=user.getId()+"";
        statistics.setBus_count(businessMapper.quarterByUserid(userid));
        statistics.setBus_last_coutn(businessMapper.lastQuarterByUserid(userid));
        statistics.setCon_count(contractMapper.quarterByUserid(userid));
        statistics.setCon_last_coutn(contractMapper.lastQuarterByUserid(userid));
        statistics.setDoc_count(documentaryMapper.quarter(userid));
        statistics.setDoc_last_coutn(documentaryMapper.lastQuarter(userid));
        statistics.setSucc_count(documentaryMapper.quarter(userid));
        statistics.setSucc_last_coutn(documentaryMapper.lastQuarter1(userid));

        return statistics;
    }

    /**
     * 根据客户所属行业 统计成交数量 成交金额
     * @return
     */
    public List<TypeStatisticsBo> industryStatistics(){
        return dataMapper.industryStatistics();
    }

    /**
     * 根据客户来源 统计成交数、成交总金额
     * @return
     */
    public List<TypeStatisticsBo> sourceStatistics(){
        return dataMapper.sourecStatistics();
    }

}
