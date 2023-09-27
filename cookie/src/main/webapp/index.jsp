<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
<%--
<% %> - JSP 声明和脚本标签（Scriptlet）：
这个标签用于在 JSP 页面中插入 Java 代码块，这些代码块会在服务器端执行。
它可以包含任何有效的 Java 代码，如变量声明、循环、条件语句等。
这里的代码块会被插入到生成的 Servlet 类中的 service 方法中，以便在处理客户端请求时执行。
通常用于执行服务器端的逻辑操作，如查询数据库、设置变量等。

<%! %> - JSP 声明标签（Declaration）：
这个标签用于定义在生成的 Servlet 类中的实例变量和方法。它们是 Servlet 类的成员，可以在整个 Servlet 中共享。
通常用于定义类级别的成员变量、方法或引入外部 Java 类。

<%= %> - JSP 表达式标签（Expression）：
这个标签用于在 JSP 页面中输出表达式的值，并将其发送到响应中。
表达式可以是任何有效的 Java 表达式，如变量、方法调用、数学表达式等。
通常用于将动态数据显示在页面上，比如从 JavaBean 中获取数据并显示。


<% %> 通常用于执行服务器端的逻辑操作，如条件判断、循环、数据库查询等。
<%! %> 用于在 Servlet 类中定义实例变量和方法，通常用于在整个 Servlet 中共享数据或引入外部 Java 类。
<%= %> 用于将动态数据嵌入到生成的 HTML 中，通常用于显示数据。



--%>