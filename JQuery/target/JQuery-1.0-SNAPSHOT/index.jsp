<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<h1><%= "Hello World!" %>

</h1>
<div id="div1">div1........</div>
<div id="div2">div2........</div>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
<script>
    //使用JQuery获取元素对象
    var div1 = $("div");
    alert(div1.length);
    div1.html("bbb");

    //    JQuery对象和JS对象区别与转换
    //     1. JQuery对象在操作时，更加方便。
    // 2. JQuery对象和js对象方法不通用的.
    //     3. 两者相互转换
    //     * jq -- > js : jq对象[索引] 或者 jq对象.get(索引)
    //     * js -- > jq : $(js对象)
    div1[0].innerHTML="ddd";

    $(function () {
    //$(function() {}) 表示在文档加载完成后执行其中的代码，它等价于 JavaScript 中的 window.onload。
    //这是因为 $ 是 jQuery 的缩写，它提供了多种方法来操作和查询文档中的元素，
    // 其中 $(document).ready(function() {}) 或简写成 $(function() {}) 用于在文档加载完成后执行指定的函数。
    //     * window.onload 只能定义一次,如果定义多次，后边的会将前边的覆盖掉
    // * $(function)可以定义多次的。
        $("#div1").css("backgroundColor","red");
        $("#div1").css("background-color","pink");
    })



</script>

</html>