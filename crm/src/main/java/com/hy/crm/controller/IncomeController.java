package com.hy.crm.controller;

import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Income;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 收入登记表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/income")
public class IncomeController {
    @Autowired
    private IIncomeService incomeService;
    @Autowired
    private IContractService iContractService;

    /**
     * 添加/收入登记
     *
     * @param
     * @return
     */
    @RequestMapping("/toInsert.do")
    @ResponseBody
    public ModelAndView toInsert(Integer cid) {
        Contract contract = iContractService.getById(cid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contract", contract);
        modelAndView.setViewName("hetong/addRegister.html");
        return modelAndView;
    }

    /**
     * 添加/收入登记
     *
     * @param income
     * @return
     */
    @RequestMapping("/addincome.do")
    //@ResponseBody
    public String insert(Income income) {
        Integer cid = income.getCid();
        System.out.println(cid);
        //String str = "1";
       boolean b = incomeService.save(income);
        if(b){
           Contract contract =  iContractService.getById(cid);
           //汇款额
           Integer many = contract.getRemittance()+income.getIncome_money();
           contract.setRemittance(many);
           iContractService.updateById(contract);
        }
        return "redirect:/hetong/contract.html";
    }
}
