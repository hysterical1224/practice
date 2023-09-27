package com.example.day_tomcat;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //request.getReader() 方法用于获取请求消息体的字符流读取器。
        //在HTTP请求中，请求消息体通常包含了客户端提交的数据，
        // 例如表单数据、文本内容等。通过调用 getReader() 方法，可以获取一个字符流读取器，
        // 从中可以读取请求消息体的内容。

        BufferedReader reader = req.getReader();
        String line = null;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
            
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //服务器端组件： Servlet 是一种服务器端的组件，用于处理客户端（浏览器）发起的请求，并生成响应。
        //
        //Java 类： Servlet 是以 Java 类的形式存在，它通常扩展自 javax.servlet.HttpServlet 类或实现了 javax.servlet.Servlet 接口。
        //
        //处理 HTTP 请求： Servlet 主要用于处理 HTTP 请求和响应。它可以接收来自客户端的请求数据（如表单数据、URL 参数等），执行一些处理逻辑（如查询数据库、生成动态内容等），然后生成相应的 HTTP 响应数据。
        //
        //生命周期： Servlet 拥有生命周期，包括初始化、请求处理和销毁阶段。
        // 在初始化阶段，Servlet 可以进行一些初始化操作。在请求处理阶段，Servlet 接收并处理请求。在销毁阶段，Servlet 可以释放资源。
        //
        //多线程处理： Servlet 容器（如 Tomcat）会为每个请求创建一个独立的线程来处理。这使得 Servlet 可以并发处理多个请求。
        //
        //Web.xml 配置： 传统的 Servlet 需要在 web.xml 配置文件中声明和映射。这样 Web 服务器知道如何将请求映射到正确的 Servlet。
        //
        //URL 映射： Servlet 可以通过 URL 映射来确定哪个 Servlet 负责处理特定的请求。这通常在 web.xml 或者使用注解进行配置。
        //
        //动态内容生成： Servlet 允许生成动态的 Web 内容。它可以通过 Java 代码生成 HTML、XML、JSON 等内容，以及与数据库进行交互。
        //
        //与 JSP 结合使用： 虽然 Servlet 可以生成动态内容，但它们通常与 JavaServer Pages（JSP）结合使用，其中 JSP 用于页面模板，而 Servlet 用于处理业务逻辑。
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");


        //1.获取请求方式 : GET
        String method = request .getMethod();
        System.out.println(method);

        //2.(*)获取虚拟目录: /tmc
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

//        /3。获取servlet路径: /hello-servlet
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

//        /4.获取get方式请求参数: null
        String queryString = request.getQueryString();
        System.out.println(queryString);

//        /5.(*)获取请求URI: /tmc/hello-servlet
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        //        /5.(*)获取请求URL:http://localhost:8080/tmc/hello-servlet
        StringBuffer requestURL = request .getRequestURL();
        System.out.println(requestURL);

        //6.获取协议及版本: HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //7.获取客户机的IP地址:
        String remoteAddr = request .getRemoteAddr();
        System.out.println(remoteAddr);

        System.out.println("----------------------------------------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"----"+value);

        }

        System.out.println("----------------------------------------------");
        String agent = request.getHeader("user-agent");
        if (agent.contains("Chrome")){
            System.out.println("谷歌.....");
        } else if (agent.contains("Firefox")){
            System.out.println("火狐。。。。");
        }
        System.out.println("----------------------------------------------");
        String refer = request.getHeader("referer");
        System.out.println(refer);

    }


    //在 Web 应用程序和 HTTP 协议的上下文中，HTTP 请求分为三个主要部分：请求行、请求头和请求正文。 每个部分都有特定的用途：
    //HTTP 请求行：请求行是 HTTP 请求的第一行，包含有关请求的基本信息。 它包括 HTTP 方法（GET、POST 等）、所请求资源的 URI（统一资源标识符）以及 HTTP 版本。
    // 请求行的目的是通知服务器正在发出的请求类型和正在访问的资源。

    //HTTP 请求头：请求头是客户端（通常是 Web 浏览器）随请求发送的附加信息。 这些标头提供有关客户端、请求的资源以及客户端首选项的详细信息。
    //常见的请求头包括“User-Agent”（标识浏览器）、“Host”（标识域）、“Accept”（指定客户端可以接受的内容类型）等等。 服务器使用请求标头来适当处理请求并发回适当的响应。
    // 请求头中的 "Accept" 是用来告诉服务器，客户端能够接受的响应内容的类型。这个头部字段指定了客户端希望服务器返回的数据类型，可以是HTML、XML、JSON 等不同的格式。
    // 服务器可以根据这个字段来决定如何生成响应内容以满足客户端的要求。
    //
    //HTTP 请求正文：请求正文是请求的负载所在的位置。 这是数据（例如表单提交、JSON、XML 或文件上传）从客户端发送到服务器的地方。
    // 例如，提交表单时，表单数据包含在请求正文中。 请求正文的目的是将数据发送到服务器进行处理，例如更新资源、添加新记录或发送文件。
    //
    //总之：
    //请求行：通知服务器请求的类型和请求的资源。
    //请求头：提供有关客户端及其偏好的其他详细信息。
    //请求正文：包含从客户端发送到服务器进行处理的数据。
    //在 Web 应用程序中，服务器端代码通常需要访问和解释 HTTP 请求的这些部分，以了解客户端请求的内容以及如何做出相应的响应。 Java 中的 HttpServletRequest 接口提供的方法（例如 getMethod()、getHeader() 和 getInputStream()）允许开发人员从请求的这些不同部分检索信息，并就如何处理请求做出明智的决策。

    public void destroy() {

    }
}