package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Clien;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.LayUI;
import com.hy.crm.mapper.ContractMapper;
import com.hy.crm.service.IClienService;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 合同表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private IClienService iClienService;
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 查询全部合同
     *
     * @param contract
     */
    @ResponseBody
    @RequestMapping("/selcontract.do")
    public LayUI select(Contract contract, Integer page, Integer limit) {
        LayUI layui = new LayUI();
        layui.setCode(0);
        layui.setMag("");
        Page page1 = PageHelper.startPage(page, limit,true);
        List<Contract> contractList = contractService.list(new QueryWrapper<Contract>());
        Long l = page1.getTotal();
        layui.setCount(l.intValue());//分页
        layui.setData(contractList);
        return layui;

    }

    /**
     * 查询所有合同列表/模糊查询
     * @return
     */
    @RequestMapping("/queryContract.do")
    @ResponseBody
    public LayUI queryAllContract(Integer page, Integer limit, Contract contract, String type, String text, String state, String contract_date){
        LayUI layui=new LayUI();
        layui.setMag("");
        layui.setCode(0);
        Page page1= PageHelper.startPage(page,limit,true);
        List<Contract> contractList=contractService.queryAllContract(contract,type,text,state,contract_date);
        System.out.println();
        Long l=page1.getTotal();
        layui.setData(contractList);
        layui.setCount(l.intValue());
        return layui;
    }

    @RequestMapping("/queryContract1.do")
    @ResponseBody
    public LayUI queryAllContract1(Integer page, Integer limit, Contract contract, String type, String text, String contract_date){
        LayUI layui=new LayUI();
        layui.setMag("");
        layui.setCode(0);
        Page page1= PageHelper.startPage(page,limit,true);
        List<Contract> contractList=contractService.queryAllContract1(contract,type,text,contract_date);
        System.out.println();
        Long l=page1.getTotal();
        layui.setData(contractList);
        layui.setCount(l.intValue());
        return layui;
    }

    /**
     * 添加合同
     *
     * @param contract
     * @return
     */
    @RequestMapping("/insertcontract.do")
    @ResponseBody
    public String insertcontract(Contract contract) {
        String str = "1";
        try {
            iContractService.save(contract);
        } catch (Exception e) {
            str="2";
            e.printStackTrace();
        }
        return str;
    }


    //去查询客户信息
    @RequestMapping("/toconadd.do")
    public ModelAndView toconadd(ModelAndView modelAndView) {
        modelAndView.addObject("unamelist", contractMapper.getname());
        modelAndView.setViewName("/hetong/esecutoryAdd");
        return modelAndView;
    }

    //根据客户id去查
    @RequestMapping("/queryInfoByid.do")
    @ResponseBody
    public Clien queryInfoByCid(Integer cid) {
        Clien clien = iClienService.getOne(new QueryWrapper<Clien>().eq("cid", cid));
        return clien;
    }

    //合同详情
    @RequestMapping("/toContract.do")
    public ModelAndView toContract(ModelAndView model,Integer cid){
        Contract contract=iContractService.getById(cid);
        model.addObject("conlist",contract);
        model.addObject("clilist",iClienService.getById(contract.getClienid()));
        model.addObject("unamelist", contractMapper.getname());
        model.setViewName("/hetong/xiangqing.html");
        return model;
    }

    @RequestMapping("/updateContract.do")
    public String update(Contract contract){
        iContractService.updateById(contract);
        return "redirect:/hetong/contract.html";
    }
}
