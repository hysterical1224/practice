package com.example.day_tomcat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRedirect", value = "/ServletRedirect")
public class ServletRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发（Forward）：
        //转发是服务器内部的操作，发生在服务器端。
        //当服务器接收到请求后，可以将请求转发到另一个资源（如另一个 Servlet 或 JSP 页面）进行处理。
        //在客户端看来，转发是透明的，客户端不知道发生了转发。
        //转发时，请求和响应对象是同一个，可以共享数据。在同一个请求中，多个资源可以通过转发进行数据传递。
        //转发的 URL 不会改变，客户端的浏览器地址栏保持不变。
        //由于转发是服务器内部的操作，对客户端是不可见的，所以浏览器地址栏不会显示转发的 URL。

        //重定向（Redirect）：
        //重定向是在客户端发生的操作，发生在浏览器端。
        //当服务器接收到请求后，会发送一个特殊的响应状态码（如 302 Found）和新的 URL 给客户端，告诉客户端去请求新的 URL。
        //客户端收到重定向响应后，会发送新的请求到指定的 URL 地址。
        //重定向后，客户端的浏览器地址栏会显示新的 URL，因为浏览器会重新发起一个新的请求。
        //重定向时，请求和响应对象是不同的，无法直接共享数据。重定向会产生新的请求和响应周期，因此数据传递需要通过其他手段，如参数、Session 等。
        //重定向的 URL 会显示在客户端浏览器地址栏中。
        this.doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        302表示重定向
        response.setStatus(302);
        response.setHeader("location","/tmc/hello-servlet");
        //response.setHeader()：
        //使用 response.setHeader("Location", newURL) 可以手动设置响应头中的 Location 字段，将客户端重定向到指定的新 URL。
        //需要手动设置状态码为适当的重定向状态码，如 302（临时重定向）或 301（永久重定向）。
        //该方法提供了更大的灵活性，可以通过设置其他响应头字段来定制重定向的行为。


        //使用 response.sendRedirect(newURL) 方法可以更方便地实现重定向。
        //自动设置状态码为 302（临时重定向）。
        //在重定向时，会清除响应的输出缓冲区中的任何内容。
        //由于自动设置了状态码和响应头，使用这种方法通常更简单，特别是在标准的重定向场景中。

        response.sendRedirect("/tmc/hello-servlet");
//         重定向的特点:redirect
        //			1. 地址栏发生变化
        //			2. 重定向可以访问其他站点(服务器)的资源
        //			3. 重定向是两次请求。不能使用request对象来共享数据
        //		* 转发的特点：forward
        //			1. 转发地址栏路径不变
        //			2. 转发只能访问当前服务器下的资源
        //			3. 转发是一次请求，可以使用request对象来共享数据


        //        * 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出
        //		  * 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)
    }
}
