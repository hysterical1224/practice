package com.example.jstl_mvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletEL_JSTL", value = "/ServletEL_JSTL")
public class ServletEL_JSTL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        <%@ %> 用于设置页面的属性和配置，<%= %> 用于将动态内容输出到页面，<%! %> 用于在页面中定义 Java 类的成员。
        //        这些标签在 JSP 中的使用有不同的用途，但它们一起构成了 JSP 页面的结构和功能。

        /**
         *  作用：用于配置JSP页面，导入资源文件
         * 	* 格式：
         * 		<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
         * 	* 分类：
         * 		1. page		： 配置JSP页面的
         * 			* contentType：等同于response.setContentType()
         * 				1. 设置响应体的mime类型以及字符集
         * 				2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
         * 			* import：导包
         * 			* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
         * 			* isErrorPage：标识当前也是是否是错误页面。
         * 				* true：是，可以使用内置对象exception
         * 				* false：否。默认值。不可以使用内置对象exception
         *
         * 		2. include	： 页面包含的。导入页面的资源文件
         * 			* <%@include file="top.jsp"%>
         * 		3. taglib	： 导入资源
         * 			* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         * 				* prefix：前缀，自定义的
         *
         *
         * 2. 注释:
         * 	1. html注释：
         * 		<!-- -->:只能注释html代码片段
         * 	2. jsp注释：推荐使用
         * 		<%-- --%>：可以注释所有
         *
         *isErrorPage 通常用于标识当前 JSP 页面是否是一个错误页面。
         * 如果设置为 true，它可以在页面中访问内置对象 exception，以便获取异常信息并显示给用户。这对于自定义错误页面非常有用。
         *
         * errorPage 通常用于配置全局错误页面，当应用程序中的任何 JSP 页面出现错误时，容器会自动跳转到指定的错误页面。
         * 这对于集中管理错误页面和提供一致的用户体验非常有用。
         *
         *
         *1. 概念：Expression Language 表达式语言
         * 2. 作用：替换和简化jsp页面中java代码的编写
         * 3. 语法：${表达式}
         * 4. 注意：
         *
         ** jsp默认支持el表达式的。如果要忽略el表达式
         * 		1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
         * 		2. \${表达式} ：忽略当前这个el表达式
         *
         *Page 域：
         * 作用范围： 仅在当前 JSP 页面内有效。
         * 存储数据： 通过在 JSP 页面内使用 <%! ... %> 或 <% ... %> 声明的变量或对象可以存储在 Page 域中。
         * 生命周期： 随着页面的执行而创建，随着页面的销毁而销毁。
         *
         * Request 域：
         * 作用范围： 在同一个请求处理周期内的所有 JSP 页面之间共享数据。
         * 存储数据： 使用 request.setAttribute("name", value) 方法将数据存储在 Request 域中。
         * 生命周期： 当前请求处理结束后，Request 域的数据将失效。
         *
         * Session 域：
         * 作用范围： 在同一个用户的不同请求之间共享数据，通常用于用户的会话管理。
         * 存储数据： 使用 session.setAttribute("name", value) 方法将数据存储在 Session 域中。
         * 生命周期： 当用户会话结束或超时时，Session 域的数据将失效。
         *
         * Application 域（ServletContext 域）：
         * 作用范围： 在整个 Web 应用程序中共享数据。
         * 存储数据： 使用 application.setAttribute("name", value) 方法将数据存储在 Application 域中。
         * 生命周期： 当 Web 应用程序被销毁或服务器被关闭时，Application 域的数据将失效。
         * 这些域提供了不同级别的数据共享和存储，开发人员可以根据需要选择合适的域来管理数据。
         * 通常情况下，Page 域主要用于存储页面级别的数据，Request 域用于在同一个请求处理周期内传递数据，
         * Session 域用于跨页面的用户会话数据，而 Application 域用于在整个应用程序范围内共享数据
         *
         *
         * */


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
