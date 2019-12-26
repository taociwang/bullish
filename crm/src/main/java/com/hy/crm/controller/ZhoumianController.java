package com.hy.crm.controller;

import com.hy.crm.service.impl.ZongheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ZhoumianController {
    @Autowired
    private ZongheService zonghe;
@RequestMapping("/zonghe.do")
    public String zonghe(Model model){
       model.addAttribute("business",zonghe.business());
       model.addAttribute("clien",zonghe.clien());
       model.addAttribute("con",zonghe.contract());
        return "/zhoumian/zhoumian.html";
    }
}
