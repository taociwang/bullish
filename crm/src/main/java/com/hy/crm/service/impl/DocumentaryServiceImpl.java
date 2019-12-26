package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.LayUI;
import com.hy.crm.entity.User;
import com.hy.crm.mapper.Doc_busMapper;
import com.hy.crm.mapper.DocumentaryMapper;
import com.hy.crm.service.IDocumentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 跟单表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class DocumentaryServiceImpl extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryService {
   @Autowired
   private DocumentaryMapper documentaryMapper;
    @Autowired
    private Doc_busMapper db;
    @Override
    public LayUI queryAll(Integer pageNum, Integer size,Documentary documentary,String kinds) {
        System.out.println(kinds);
        //Page page = PageHelper.startPage(size,pageNum,true);
        IPage page=new Page(size,pageNum);
        QueryWrapper wrapper=new QueryWrapper();
        if(!"-1".equals(kinds)){
            if(null !=documentary){
                if(null !=documentary.getClassify()){
                    if(kinds.equals("date")){
                        wrapper.eq("date",documentary.getClassify());
                    }else if(kinds.equals("classify")){
                        wrapper.like("classify",documentary.getClassify());
                    }
                }
            }
        }
        page=documentaryMapper.selectPage(page,wrapper);
        LayUI layui = new LayUI();
        layui.setCode(0);
        layui.setMsg("");
        Long l = page.getTotal();
        layui.setCount(l.intValue());
        layui.setData(page.getRecords());
        return layui;
    }
  /*  @Override
    public void addDoc(Documentary documentary){
        documentaryMapper.insert(documentary);
    }*/

    @Override
    public LayUI queryMy(Integer pageNum, Integer size,Documentary documentary,String kinds,User user) {
        System.out.println(kinds);
       // Page page = PageHelper.startPage(size,pageNum,true);
        IPage page=new Page(size,pageNum);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("dpeople",user.getUsername());
        if(!"-1".equals(kinds)){
            if(null !=documentary){
                if(null !=documentary.getClassify()){
                    if(kinds.equals("date")){
                        wrapper.eq("date",documentary.getClassify());
                    }else if(kinds.equals("classify")){
                        wrapper.like("classify",documentary.getClassify());
                    }
                }
            }
        }
        page=documentaryMapper.selectPage(page,wrapper);
        LayUI layui = new LayUI();
        layui.setCode(0);
        layui.setMsg("");
        Long l = page.getTotal();
        layui.setCount(l.intValue());
        layui.setData(page.getRecords());
        return layui;
    }
    public List<Business> queryBus(){
        return db.queryBus();
    }
    public List<Documentary> querySj(Integer busid){
        return db.querySj(busid);
    }
}
