package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Forum;
import com.hy.crm.entity.Layui;
import com.hy.crm.service.IForumService;
import com.hy.crm.service.impl.ForumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 论坛表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/forum")
public class ForumController {
    @Autowired
    private IForumService iForumService;
    @Autowired
    private ForumServiceImpl forumService;


    /**
     * 查询所有论坛列表/模糊查询
     * @return
     */
    @RequestMapping("/queryCust.do")
    @ResponseBody
    public Layui queryCust(Integer page, Integer limit,Forum forum,String kinds,String text){
        Layui layui=new Layui();
        layui.setMag("");
        layui.setCode(0);
        Page page1= PageHelper.startPage(page,limit,true);
        List<Forum> list=forumService.queryAllCust(forum,kinds,text);
        System.out.println();
        Long l=page1.getTotal();
        layui.setData(list);
        layui.setCount(l.intValue());
        return layui;
    }

     /**
     * 查询全部帖子
     *
     * @param forum
     */
    @ResponseBody
    @RequestMapping("/select.do")
    public Layui select(Forum forum,Integer page,Integer limit) {
        Layui layui = new Layui();
        layui.setCode(0);
        layui.setMag("");
        Page page1 = PageHelper.startPage(page, limit, true);
        List<Forum> forumList = iForumService.list(new QueryWrapper<Forum>());
        Long l = page1.getTotal();
        layui.setCount(l.intValue());//分页
        layui.setData(forumList);
        return layui;

    }

    /**
     * 添加
     *
     * @param forum
     * @return
     */
    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert(Forum forum) {
        System.out.println(forum.getNeirong());
        String str = "1";
        try {
            iForumService.save(forum);
        } catch (Exception e) {
            str="2";
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 去查询论坛
     * @param model
     * @param fid
     * @return
     */
    @RequestMapping("/thetheme.do")
    public String Thetheme(Model model, Integer fid){
        forumService.click(fid);
       model.addAttribute("thelist",forumService.theid(fid));
       model.addAttribute("the1list",forumService.theid1(fid));
        return "luntan/xiangqing";
    }
}
