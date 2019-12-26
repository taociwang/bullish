package com.hy.crm.controller;

import com.hy.crm.entity.Reply;
import com.hy.crm.service.impl.ReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * <p>
 * 帖子回复表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/reply")
public class ReplyController {
    @Autowired
    private ReplyServiceImpl replyService;


    @RequestMapping("/add.do")
    public String add(Reply reply){
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        reply.setReply_time(new Date());
        replyService.addreply(reply);
        return "redirect:/luntan/luntan.html";
    }

}
