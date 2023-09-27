package com.example.day_tomcat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletPostMass", value = "/ServletPostMass")
public class ServletPostMass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发：一个服务器内部的资源跳转
        //request.getRequestDispatcher 是 Java Servlet 中的一个方法，
        // 用于获取请求分派器（RequestDispatcher）对象，
        // 用于将请求转发给其他资源（如Servlet、JSP页面等）进行处理。
        // 它提供了在服务器内部转发请求的机制，使得在同一个应用程序内的不同组件之间可以共享请求和响应对象。

        //请求转发（Forward）： 请求转发是指将当前请求对象传递给另一个资源进行处理。
        // 这个资源可以是一个Servlet、JSP页面或其他能够处理HTTP请求的组件。
        //通过请求转发，可以将多个组件串联起来，共同完成一系列的操作，同时共享请求和响应对象。
        request.getRequestDispatcher("/hello-servlet").forward(request,response);
        //包含是指在当前的响应中嵌入另一个资源的输出内容。通过请求包含，可以将另一个资源生成的内容合并到当前的响应中。
        //这通常用于在不同的组件中共享一些公共的内容，比如导航栏或页脚。示例代码如下：
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
    }
}
