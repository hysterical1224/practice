<%--
  Created by IntelliJ IDEA.
  User: pc_ss
  Date: 2023/9/6
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
* 在jsp页面中不需要创建，直接使用的对象
	* 一共有9个：
			变量名					真实类型						作用
		* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
		* request					HttpServletRequest			一次请求访问的多个资源(转发)
		* session					HttpSession					一次会话的多个请求间
		* application				ServletContext				所有用户间共享数据
		* response					HttpServletResponse			响应对象
		* page						Object						当前页面(Servlet)的对象  this
		* out						JspWriter					输出对象，数据输出到页面上
		* config					ServletConfig				Servlet的配置对象
		* exception					Throwable					异常对象



pageContext 是 JSP 页面上下文对象，它提供了对 JSP 页面内各种作用域（page、request、session、application）以及其他一些功能的访问。
pageContext 是一个隐式对象，不需要显式创建，可以直接在 JSP 页面中使用。
以下是 pageContext 的一些主要功能和属性：

作用域对象访问：
pageContext 允许访问页面作用域（page scope）的对象，这些对象通常是由页面内定义的变量或通过 <jsp:useBean> 标签创建的 JavaBean 对象。

请求对象、会话对象、应用程序对象访问：
pageContext 可以访问请求对象、会话对象和应用程序对象，分别对应了 request、session 和 application 对象。

页面转发和包含：
pageContext 具有 forward() 和 include() 方法，允许执行页面的转发和包含操作。

页面上下文属性：
pageContext 允许设置和获取页面上下文属性，这些属性在页面之间共享。

页面内部对象访问：
通过 pageContext，可以访问其他隐式对象，如 out、request、session 和 application，
例如：pageContext.getRequest() 和 pageContext.getOut()。



PageContext：

pagecontext 是 javax.servlet.jsp.PageContext 类的实例，它是 JSP 页面的上下文对象，用于在页面中获取各种对象和信息。
pagecontext 可以在整个页面的生命周期内访问，包括页面的多次请求和响应。
它提供了访问 JSP 页面的其他隐式对象（如 request、response、session、application）以及自定义标签库中的属性和方法的途径。
pagecontext 可以在整个页面的范围内共享数据，例如在页面的不同部分或标签之间传递数据。
Page：

page 是 JSP 页面的一个隐式对象，它表示当前 JSP 页面的实例。
page 对象主要用于执行 JSP 页面的 Java 代码片段，它通常包含在 <% %> 标签中。
page 对象的生命周期与页面的一次请求和响应相对应。每次请求都会创建一个新的 page 对象，处理完请求后会销毁。
page 对象不提供访问其他隐式对象的功能，因为它主要用于执行页面的逻辑部分。


--%>

</body>
</html>
