package com.example.day_tomcat;

import com.example.utils.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletDownload", value = "/ServletDownload")
public class ServletDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //文件下载需求：
        //	1. 页面显示超链接
        //	2. 点击超链接后弹出下载提示框
        //	3. 完成图片文件下载

        //分析：
        //	1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求
        //	2. 任何资源都必须弹出下载提示框
        //	3. 使用响应头设置资源的打开方式：
        //		* content-disposition:attachment;filename=xxx

        //        通过将 Content-Disposition 设置为 attachment，可以告诉浏览器将响应内容当作附件进行下载，而不是直接在浏览器中显示。
        //        同时，你可以使用 filename 参数来指定下载时的文件名。
//        如果你希望浏览器直接显示响应内容，而不是下载附件，可以将 Content-Disposition 设置为 inline。
        String filename = request.getParameter( "filename");
        System.out.println(filename);
        System.out.println("-----------------");
        String agent = request.getHeader("user-agent");
        filename =DownLoadUtils.getFileName(agent,filename);
        System.out.println(filename);
        //2使用字节输入流加载文件进内存/2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();

        String realPath = servletContext.getRealPath( "/WEB-INF/img/" + filename);
        FileInputStream fis= new FileInputStream(realPath);
        //2.2用字节流关联
        //3.设置response的响应头//3.1设置响应头类型: content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型response.setHeader( s: "content-type", mimeType );//3.2设置响应头打开方式:content-disposition
        response.setHeader( "content-type", mimeType);
        response.setHeader( "content-disposition", "attachment ;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream( );
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos .write(buff, 0, len);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
