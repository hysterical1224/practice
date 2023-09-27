<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>


    <%
        //在域中存储数据
        session.setAttribute("name","李四");

        request.setAttribute("name","张三");
        session.setAttribute("age","23");

        request.setAttribute("str","");

    %>

<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}

${name}
${sessionScope.name}
<%--{request.user.name} 可以访问 getName 方法的原因是 EL（Expression Language，表达式语言）支持 JavaBean 规范，
它允许通过属性名称来访问 JavaBean 对象的 getter 方法。

在这种情况下，假设 user 是一个 JavaBean 对象，它有一个 name 属性，并且有一个与之对应的 getName 方法。
EL 表达式会按照 JavaBean 规范的命名约定自动查找并调用 getName 方法，从而获取 name 属性的值。

EL 表达式的语法和规则允许你以一种简单的方式访问 JavaBean 对象的属性，而不必显式调用 getter 方法。这样可以使 JSP 页面更加简洁--%>




</body>
</html>
