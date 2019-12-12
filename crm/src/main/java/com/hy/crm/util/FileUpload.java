package com.hy.crm.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 文件上传下载
 */
public class FileUpload {

    /**
     * 文件上传 直接传入一个MultipartFile文件
     * @param file
     * @return
     */
    public String upload(MultipartFile file,HttpServletRequest request) {
        if (null != file) {
            String myFileName = file.getOriginalFilename();// 文件原名称

            String fileName="CRMFileUpload";//文件夹名称
            String path=request.getServletContext().getRealPath("/");
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

    /**
     * from 表单上传 数据库存路径
     * @param request
     * @throws Exception
     */
    public void formUpload(HttpServletRequest request) throws Exception{
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        String fileName="FileUpload";
        Map<String, String> map=new HashMap<>();
        List<FileItem> fileItemList=upload.parseRequest(request);
        if(null!=fileItemList && fileItemList.size()>0){
            for(FileItem fileItem: fileItemList){
                if(!fileItem.isFormField()){
                    //from表单普通name value
                    String name=fileItem.getFieldName();
                    String value=fileItem.getString();
                    value=new String(value.getBytes("iso-8859-1"),"utf-8");
                    map.put(name, value);
                }else {
                    //文件
                    InputStream is=fileItem.getInputStream();

                    String path=request.getServletContext().getRealPath("/");
                    path=path.substring(0, path.length()-1);
                    path=path.substring(0,path.lastIndexOf("\\"));

                    File file=new File(path,fileName);
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    String src=fileName+"\\"+fileItem.getName();//获取文件名称 路径
                    String name=fileItem.getFieldName();
                    map.put(name, src);

                    //list.add(src);
                    FileOutputStream fos=new FileOutputStream(new File(file,fileItem.getName()));
                    byte[] b=new byte[2048];
                    int len=0;
                    while((len=is.read(b))!=-1){
                        fos.write(b, 0, len);
                    }
                    fos.flush();
                    fos.close();
                }
            }
        }

    }
}
