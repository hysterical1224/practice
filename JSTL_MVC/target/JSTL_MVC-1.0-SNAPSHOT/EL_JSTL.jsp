<%--
  Created by IntelliJ IDEA.
  User: pc_ss
  Date: 2023/9/6
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
1. page		： 配置JSP页面的
			* contentType：等同于response.setContentType()
				1. 设置响应体的mime类型以及字符集
				2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
			* import：导包
			* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
			* isErrorPage：标识当前也是是否是错误页面。
				* true：是，可以使用内置对象exception
				* false：否。默认值。不可以使用内置对象exception
2. include	： 页面包含的。导入页面的资源文件
			* <%@include file="top.jsp"%>
		3. taglib	： 导入资源
			* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				* prefix：前缀，自定义的


--%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<%@ include %> 指令：
<%@ include %> 是用于包含其他文件内容到当前 JSP 页面中的指令。
它是在 JSP 页面编译阶段被处理的，所包含的文件会被静态地合并到当前页面中，因此在输出中不会生成包含指令的信息。
主要用于在 JSP 页面中引入其他的静态内容，如 HTML 片段、文本文件、其他 JSP 页面等。
被包含的内容与包含它的页面处于同一个作用域，可以访问同一份请求和响应对象。


<%@ taglib %> 指令：
<%@ taglib %> 是用于引入自定义标签库的指令，用于扩展 JSP 的标签集合。
它用于声明自定义标签库的命名空间（Namespace）和 URI，以便在 JSP 页面中使用自定义标签。
自定义标签库通常包含自定义标签的定义，允许开发人员在 JSP 页面中像使用内置标签一样使用这些自定义标签。
通过 <%@ taglib %> 指令，可以将标签库引入到 JSP 页面中，并通过声明的命名空间使用标签。

<%@ include %> 用于静态包含，将其他文件的内容合并到当前 JSP 页面中，适用于静态内容的嵌入。
<%@ taglib %> 用于引入自定义标签库，扩展 JSP 的功能，适用于在 JSP 页面中使用自定义标签，实现更复杂的逻辑和功能。
综上所述，<%@ include %> 主要用于页面内容的静态包含，而 <%@ taglib %> 主要用于引入自定义标签库以扩展 JSP 功能。它们在功能和应用场景上有很大的不同。

--%>

</body>
</html>
