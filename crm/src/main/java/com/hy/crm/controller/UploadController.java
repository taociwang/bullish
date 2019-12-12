package com.hy.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class UploadController {
    public static String url="";
    /**
     * 文件上传 直接传入一个MultipartFile文件
     * @param file
     * @return
     */
    @RequestMapping("/upload.do")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) {
        if (null != file) {
            String myFileName = file.getOriginalFilename();// 文件原名称

            String fileName="CRMFileUpload";//文件夹名称

            String path=request.getServletContext().getRealPath("/");
            System.out.println("path:"+path);
            path=path.substring(0, path.length()-1);
            path=path.substring(0,path.lastIndexOf("\\"));
            System.out.println(path);

            File fileDir=new File(path,fileName);//new一个文件夹对象
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            File localFile = new File(fileDir,myFileName);//在CRMFileUpload文件夹下创建一个文件对象作为上传的真正位置
            try {
                file.transferTo(localFile);//将文件对象内容复制到localFile
                url=fileName+"/"+myFileName;
                return "1";
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return "0";
    }

    /*
   根据文件所在路径下载文件
    */
    @RequestMapping("/download.do")
    public void download(HttpServletResponse response, HttpServletRequest request, String filePath){
        String path=request.getServletContext().getRealPath("/");
        System.out.println("path:"+path);
        path=path.substring(0, path.length()-1);
        path=path.substring(0,path.lastIndexOf("\\"));
        File file = new File(path,filePath);
        // 取得文件名。
        String fileName = file.getName();
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("utf-8"), "iso8859-1"));
            response.setHeader("Content-Length", String.valueOf(file.length()));

            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
            response.flushBuffer();
            fis.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
