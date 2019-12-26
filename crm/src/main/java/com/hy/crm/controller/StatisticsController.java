package com.hy.crm.controller;

import com.hy.crm.bo.TypeStatisticsBo;
import com.hy.crm.entity.User;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.impl.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    /**
     * 全部统计
     * @return
     */
    @RequestMapping("/statistics.do")
    @ResponseBody
    public Map<String,Integer> statistics(){
        return statisticsService.statistics();
    }

    /**
     * 周统计
     * @param request
     * @return
     */
    @RequestMapping("/weekStatistics.do")
    public String weekStatistics(HttpServletRequest request, Model model){
        User user=(User) request.getSession().getAttribute("user");
        model.addAttribute("statistics",statisticsService.week_statistics(user));
        return "statistics/week";
    }

    /**
     * 月统计
     * @param request
     * @return
     */
    @RequestMapping("/monthStatistics.do")
    public String monthStatistics(HttpServletRequest request, Model model){
        User user=(User) request.getSession().getAttribute("user");
        model.addAttribute("statistics",statisticsService.monthStatistics(user));
        return "statistics/month";
    }

    /**
     * 季度统计
     * @param request
     * @return
     */
    @RequestMapping("/quarterStatistics.do")
    public String quarterStatistics(HttpServletRequest request, Model model){
        User user=(User) request.getSession().getAttribute("user");
        model.addAttribute("statistics",statisticsService.monthStatistics(user));
        return "statistics/quarter";
    }



    /**
     * 根据客户来源 统计成交数、成交总金额
     * @return
     */
    @RequestMapping("/sourceStatistics.do")
    public String sourceStatistics(Model model){
        model.addAttribute("sourceStatisticsList",statisticsService.sourceStatistics());
        return "statistics/source";
    }
    /**
     * 根据客户来源 统计成交数、成交总金额
     * @return
     */
    @RequestMapping("/source.do")
    @ResponseBody
    public List<TypeStatisticsBo> source(Model model){
        return statisticsService.sourceStatistics();
    }

    /**
     * 根据客户所属行业 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/industryStatistics.do")
    public String industryStatistics(Model model){
       model.addAttribute("industryStatisticsList",statisticsService.industryStatistics());
       return "statistics/industry";
    }

    /**
     * 根据客户所属行业 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/industry.do")
    @ResponseBody
    public List<TypeStatisticsBo> industry(Model model){
        return statisticsService.industryStatistics();
    }

    /**
     * 所有商机 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/funnel.do")
    @ResponseBody
    public List<TypeStatisticsBo> funnel(){
        return statisticsService.funnel();
    }

    /**
     * 年度商机 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/yearFunnel.do")
    @ResponseBody
    public List<TypeStatisticsBo> yearFunnel(){
        return statisticsService.yearFunnel();
    }

    /**
     * 上年度商机 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/lastYearFunnel.do")
    @ResponseBody
    public List<TypeStatisticsBo> lastYearFunnel(){
        return statisticsService.lastYearFunnel();
    }

    /**
     * 本季度商机 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/quarterFunnel.do")
    @ResponseBody
    public List<TypeStatisticsBo> quarterFunnel(){
        return statisticsService.quarterFunnel();
    }

    /**
     * 上季度商机 统计成交数量 成交金额
     * @return
     */
    @RequestMapping("/lastQuarterFunnel.do")
    @ResponseBody
    public List<TypeStatisticsBo> lastQuarterFunnel(){
        return statisticsService.lastQuarterFunnel();
    }

}
