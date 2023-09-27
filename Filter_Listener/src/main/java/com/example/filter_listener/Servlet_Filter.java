package com.example.filter_listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Filter", value = "/Servlet_Filter")
public class Servlet_Filter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        作用： 过滤器用于在请求和响应之间执行某种操作。它可以拦截请求、修改请求参数、验证用户身份、记录请求日志、处理异常等。
        //        过滤器通常用于对请求或响应进行预处理或后处理，以实现一些通用的功能，如身份验证、日志记录、字符编码设置等。
        //
        //应用场景：
        //身份验证和授权： 可以使用过滤器来验证用户的登录状态，并根据用户角色授权访问权限。
        //日志记录： 可以记录请求和响应的信息，用于监控和审计。
        //字符编码设置： 可以在请求到达时设置字符编码，确保数据的正确处理。
        //请求参数处理： 可以在请求到达之前对参数进行解析和处理。
        //异常处理： 可以捕获异常并进行统一的错误处理。
        //请求过滤： 可以拦截特定类型的请求，如图片、文件下载等。

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //监听器（Listener）：
        //
        //作用： 监听器用于监听 Web 应用中的事件，当事件发生时，监听器可以执行相应的逻辑。它可以监听 ServletContext、HttpSession 和 ServletRequest 等对象的创建和销毁，以及属性的修改等事件。
        //
        //应用场景：
        //
        //应用初始化： ServletContextListener 可以监听应用的启动和关闭事件，用于初始化全局配置、数据库连接等资源。
        //会话管理： HttpSessionListener 可以监听会话的创建和销毁事件，用于统计在线用户数、清理会话数据等。
        //请求监听： ServletRequestListener 可以监听请求的创建和销毁事件，用于记录请求信息、处理资源释放等。
        //属性监听： HttpSessionAttributeListener 和 ServletContextAttributeListener 可以监听属性的添加、删除和替换事件，用于属性变化时的逻辑处理。
        //总的来说，过滤器主要用于处理请求和响应的内容，而监听器主要用于监听 Web 应用中的事件。它们都可以用于实现一些通用功能，提高代码的可维护性和可扩展性，
        // 以及增强 Web 应用的功能。在开发中，根据具体需求选择使用过滤器或监听器，或者结合两者来实现更复杂的功能。
    }
}
