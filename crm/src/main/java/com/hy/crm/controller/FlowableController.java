package com.hy.crm.controller;

import com.hy.crm.bo.Flowable;
import com.hy.crm.entity.User;
import com.hy.crm.flowable.FlowableTest;
import com.hy.crm.service.impl.FlowableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("flowable")
public class FlowableController {
    @Autowired
    private FlowableTest flowableTest;
    @Autowired
    private FlowableService flowableService;

    private List<String> list=new ArrayList<>();
    /**
     * 获取session中用户对象
     * @return
     */
    @RequestMapping("/toadd.do")
    public String toadd(HttpServletRequest request, Model model){
        User user=(User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "flowable/add";
    }

    /**
     * 启动流程 添加一条请假记录
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Flowable flowable){
        System.out.println(flowable);
        String id=flowableService.startProcessInstanceTest(flowable);
        list.add(id);
        return "redirect:/flowable/query.do";
    }

    /**
     * 展示所有申请
     * @param model
     * @return
     */
    @RequestMapping("/query.do")
    public String query(Model model){
        model.addAttribute("flowableList",flowableService.query());
        return "flowable/query";
    }

    /**
     * 查看申请详情
     * @param model
     * @param index
     * @return
     */
    @RequestMapping("/toUpdate.do")
    public String toUpdate(Model model,Integer index){
        model.addAttribute("flowable",flowableService.toUpdate(index));
        //model.addAttribute("activities",flowableService. queryHistoryData());
        return "flowable/update";
    }

    /**
     * 完成
     * @param approved 同意不同意
     * @param index 下标
     * @param postil 批注
     */
    @RequestMapping("/update.do")
    public String update(boolean approved,Integer index,String postil){
        flowableService.update(approved,index,postil);
        return "redirect:flowable/query.do";
    }
}
