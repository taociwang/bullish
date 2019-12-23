package com.hy.crm.controller;


import com.hy.crm.entity.After_sale;
import com.hy.crm.entity.Clien;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Data;
import com.hy.crm.service.impl.After_saleServiceImpl;
import com.hy.crm.service.impl.ClienServiceImpl;
import com.hy.crm.service.impl.ContractServiceImpl;
import com.hy.crm.service.impl.DataServiceImpl;
import com.hy.crm.util.LayuiData;
import net.sf.jsqlparser.statement.select.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.zip.DataFormatException;

/**
 * <p>
 * 售后 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/after-sale")
public class After_saleController {
    @Autowired
    private After_saleServiceImpl after_saleService;
    @Autowired
    private ClienServiceImpl clienService;
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private DataServiceImpl dataService;
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/query.do")
    @ResponseBody
    public LayuiData query(After_sale after_sale,Integer page, Integer limit,String column,String value){
        return after_saleService.query(after_sale,page,limit,column,value);
    }

    /**
     * 统计数量
     * @return
     */
    @RequestMapping("/statistics.do")
    @ResponseBody
    public List<Long> statistics(){
        return after_saleService.counts();
    }

    /**
     * 查询所有客户名称
     * @return
     */
    @RequestMapping("/queryClien.do")
    @ResponseBody
    public List<Clien> queryClien(){
        return clienService.list(null);
    }

    /**
     * 根据客户id查询所有合同
     * @return
     */
    @RequestMapping("/queryContract.do")
    @ResponseBody
    public List<Contract> queryContract(String clienid){
        return contractService.queryContractByClienid(clienid);
    }

    /**
     * 根据客户id查询所有合同
     * @return
     */
    @RequestMapping("/queryContractById.do")
    @ResponseBody
    public Contract queryContractById(String contractid){
        return contractService.getById(contractid);
    }

    /**
     * 根据typeid 查询所有
     * @param typeid
     * @return
     */
    @RequestMapping("/queryDataType.do")
    @ResponseBody
    public List<Data> queryDataType(String typeid){
        return dataService.queryDataType(typeid);
    }

    /**
     * 保存
     * @param after_sale
     * @return
     */
    @RequestMapping("/add.do")
    public String add(After_sale after_sale){
        after_sale.setAccessory(UploadController.url);
        after_saleService.save(after_sale);
        return "redirect:/after_sale/query.html";
    }

    /**
     * 根据id查询售后详情
     * @param id
     * @return
     */
    @RequestMapping("/toUpdate.do")
    public String toUpdate(String id, Model model){
        model.addAttribute("after_sale_po",after_saleService.queryById(id));
        return "after_sale/details";
    }

}
