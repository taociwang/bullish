package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.*;
import com.hy.crm.service.impl.DataServiceImpl;
import com.hy.crm.service.impl.Doc_dataServicelmpl;
import com.hy.crm.service.impl.DocumentaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 跟单表 前端控制器
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/documentary")
public class DocumentaryController {
    @Autowired
    private Doc_dataServicelmpl doc_data;
    @Autowired
    private DocumentaryServiceImpl documentaryService;
    @Autowired
    private DataServiceImpl dataService;

    public DocumentaryServiceImpl getDocumentaryService() {
        return documentaryService;
    }

    public void setDocumentaryService(DocumentaryServiceImpl documentaryService) {
        this.documentaryService = documentaryService;
    }

    public DataServiceImpl getDataService() {
        return dataService;
    }

    public void setDataService(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    public Doc_dataServicelmpl getDoc_data() {
        return doc_data;
    }

    public void setDoc_data(Doc_dataServicelmpl doc_data) {
        this.doc_data = doc_data;
    }

    @ResponseBody
    @RequestMapping("/gendanAll.do")
    public LayUI qureyall(Integer limit, Integer page,Documentary documentary,String kinds) {

        return documentaryService.queryAll(limit,page,documentary,kinds);


    }
    @ResponseBody
    @RequestMapping("/toname.do")
    public User toUname(Model model,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getUsername());
        return user;
    }

    @ResponseBody
    @RequestMapping("/todoc.do")
    public List<Data> toAddDoc() {

        return dataService.list(new QueryWrapper<Data>());
        /*model.addAttribute("doc",documentaryService.list(new QueryWrapper<Documentary>()));*/
    }
    @ResponseBody
    @RequestMapping("/tobus.do")
    public List<Business> toAdd() {
        System.out.println(documentaryService.queryBus());
        return documentaryService.queryBus();
    }
    @ResponseBody
     @RequestMapping("/tocha.do")
    public List<Documentary> toCha(Integer busid){
        System.out.println(documentaryService.querySj(busid));
        return  documentaryService.querySj(busid);
    }

    /*  @ResponseBody*/
    @RequestMapping("/addDoc.do")
    public String addDoc(Documentary doc,HttpServletRequest request) {
     /*   boolean b=   documentaryService.save(doc);
        String i = "";
        if (b = true){
            i = "1";
        }else {
            i="999";
        }
        return i;*/
        User user = (User) request.getSession().getAttribute("user");
        documentaryService.save(doc);
        return "redirect:/gandan/gendan.html";
    }

    @ResponseBody
    @RequestMapping("/qureydd.do")
    public LayUI qureydd() {
        LayUI layUI = new LayUI();

        layUI.setCode(0);
        layUI.setMag("");
        layUI.setData(doc_data.querydd());
        return layUI;
    }

  /*  @ResponseBody
    @RequestMapping("/upload.action")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        String i = "";
        try {
            InputStream inputStream = multipartFile.getInputStream();
            List<Documentary> list = uploadService.fileUpload(inputStream, StuBean.class);
            boolean b = stuServic.saveBatch(list);
            if (b) {
                i = "1";
            } else {
                i = "2";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;

    }*/
  @ResponseBody
  @RequestMapping("/qureymy.do")
  public LayUI queryMy(HttpServletRequest request,Integer limit, Integer page,Documentary documentary,String kinds){
     User user = (User) request.getSession().getAttribute("user");

      return documentaryService.queryMy(limit,page,documentary,kinds,user);
  }
}

