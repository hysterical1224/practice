package com.example.day_tomcat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContext", value = "/ServletContext")
public class ServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext 是 Java Web 应用程序中的一个重要接口，它代表了整个 Web 应用程序的上下文环境，提供了访问应用程序范围内资源和信息的方法。
        // 每个 Web 应用程序都有一个对应的 ServletContext 实例，它在整个应用程序的生命周期中都存在。
        //
        //主要作用和特点：
        //应用程序范围的信息共享： ServletContext 允许在整个 Web 应用程序中共享信息。你可以将数据存储在 ServletContext 中，
        // 在不同的 Servlet、JSP 或其他组件之间共享和访问这些数据。
        //
        //Servlet 生命周期监听： ServletContext 允许注册监听器以监听应用程序的生命周期事件，
        // 如应用程序初始化、销毁等。这允许你在应用程序的不同阶段执行特定的操作。
        //
        //资源访问： 通过 ServletContext，你可以访问应用程序中的资源，如 HTML、JSP、图片、配置文件等。
        // 你可以使用 getResource() 方法来获取这些资源的 URL。
        //
        //获取初始化参数： ServletContext 允许你从部署描述符（web.xml）中获取应用程序的初始化参数，这些参数可以在应用程序启动时被读取。
        //
        //动态注册 Servlet 和 Filter： ServletContext 提供了动态注册 Servlet 和 Filter 的方法，允许你在应用程序运行时添加、修改和删除这些组件。
        //
        //获取 MIME 类型： ServletContext 可以根据文件名获取对应的 MIME 类型，帮助正确设置 HTTP 响应头中的 Content-Type。
        //
        //线程安全： ServletContext 是一个在多个线程之间共享的对象，但它本身是线程安全的。它保证了在多线程环境中对共享数据的访问安全。



        //        MIME（Multipurpose Internet Mail Extensions）是一种多用途互联网邮件扩展，它是一种标准化的方式，用于表示文档文件的性质和格式。
        //        虽然最初设计用于电子邮件，但现在它被广泛应用于 Web 上的资源传输，尤其是在 HTTP 协议中用于指定传输的数据类型。


        //        MIME 类型通过一个字符串标识资源的媒体类型和子类型，常见的格式是 type/subtype。
        //        MIME 类型的主要用途是告诉浏览器或客户端如何正确解析和处理服务器返回的数据。

    }
}
