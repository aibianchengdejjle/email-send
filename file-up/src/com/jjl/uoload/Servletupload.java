package com.jjl.uoload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class Servletupload extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       /* //判断文件是否为普通文件
        if(ServletFileUpload.isMultipartContent(request)){
            return;//普通的不带文件直接返回
        }else {
            //创建文件的上传文件建议放在web-inf目录下
            String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
            File uploadfile=new File(uploadPath);
            if(uploadfile.exists()){
                uploadfile.mkdirs();//创建这个目录
            }
            //缓存文件
            //如果超出预期的大小，会放放在其他路劲
            //创建文件的上传文件建议放在web-inf目录下
            String tempPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
            File file=new File(tempPath);
            if(!file.exists()){
                file.mkdirs();//创建这个临时目录
            }
        }
        //创建  处理文件比较大的时候
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
       //获取 servletFileupload
        ServletFileUpload upload=new ServletFileUpload(diskFileItemFactory);
        //监听文件上传进度
      //  upload.setProgressListener();
        //处理上传文件
        //把前端请求解析，封装成一个FileItem对象
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            //每一个表单对象
            for (FileItem fileItem : fileItems) {
                //判断他是不是文件
                if(fileItem.isFormField()){
                    String name=fileItem.getFieldName();
                    String value=fileItem.getString("UTF-8");
                    System.out.println(name+"   "+value);
                }else {//如果是文件的话
                    String uploadfilename=fileItem.getFieldName();
                    if(uploadfilename.trim().equals("")||uploadfilename==""){
                        continue;
                    }
                    //获得上传的文件名
                    String filename=uploadfilename.substring(uploadfilename.lastIndexOf("/")+1);
                    //获取文件的后缀名
                    String fileExName=uploadfilename.substring(uploadfilename.lastIndexOf(".")+1);
                    //可以使用UUID（唯一识别的通用码），保证文件名为一
                    String uuidPath = UUID.randomUUID().toString();
                    System.out.println(uuidPath);
                    //存放地址
                    String realPath=uuidPath+"/"+uuidPath;
                    File realPathFile = new File(realPath);
                    if(!realPathFile.exists()){
                        realPathFile.mkdirs();
                    }
                    //文件传输
                    InputStream inputStream=fileItem.getInputStream();
                    FileOutputStream fos=new FileOutputStream(realPath+"/"+filename);
                    //创建一个缓冲区
                    byte[] buffer=new byte[1024];
                    int len=0;
                    while((len=inputStream.read(buffer))>0){
                        fos.write(buffer,0,len);
                    }
                    fos.close();
                    inputStream.close();
                    String msg="文件上传成功";
                    request.setAttribute("msg",msg);
                    //转发至成功页面
                    request.getRequestDispatcher("/infor.jsp").forward(request,response);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }*/
    }
}
