package com.hy.crm.controller;

import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Invoice;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 开票申请单表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/invoice")
public class InvoiceController {
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private IContractService iContractService;

    /**
     * 添加/开票申请单
     *
     * @param
     * @return
     */
    @RequestMapping("/toInvoice.do")
    @ResponseBody
    public ModelAndView toInsert(Integer cid) {
        Contract contract = iContractService.getById(cid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contract", contract);
        modelAndView.setViewName("hetong/addInvoiceApplication.html");
        return modelAndView;
    }

    /**
     * 添加/开票申请单
     *
     * @param invoice
     * @return
     */
    @RequestMapping("/addinvoice.do")
    //@ResponseBody
    public String insert(Invoice invoice) {
        Integer cid = invoice.getCid();
        System.out.println(cid);
        //String str = "1";
        boolean b = iInvoiceService.save(invoice);
        if (b) {
            Contract contract = iContractService.getById(cid);
            //开票额
            Integer many = contract.getKaipiao_money() + invoice.getMoney();
            contract.setKaipiao_money(many);
            System.out.println(contract.getKaipiao_money());
            iContractService.updateById(contract);
        }
        return "redirect:/hetong/contract.html";
    }

}
