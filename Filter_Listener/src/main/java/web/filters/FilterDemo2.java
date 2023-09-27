package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "FilterDemo2",value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
@WebFilter(filterName = "FilterDemo2",value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
public class FilterDemo2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        //dispatcherTypes 和 value 是两个不同的过滤器配置属性，它们用于不同的目的，并不会重复设置过滤器。
        //
        //dispatcherTypes: dispatcherTypes 用于指定在何种类型的请求分发情况下触发过滤器。
        // 它允许你选择在请求的不同生命周期或类型下触发过滤器，如前面所述。

        //value 或 urlPatterns: 这是用于指定过滤器应该拦截的 URL 模式的属性。
        // 它定义了哪些请求会受到过滤器的影响。
        // 通常，你会将这个属性设置为一个字符串数组，列出过滤器需要拦截的 URL 模式。
        // 例如，/servlet/* 表示拦截以 "/servlet/" 开头的所有请求。
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Request");
        chain.doFilter(request, response);
        //以下是一些适用于 dispatcherTypes = DispatcherType.REQUEST 的应用场景：
        //
        //处理 HTTP 请求：这是最常见的用例。过滤器可以用来在请求到达 Servlet 之前或之后执行一些操作，例如身份验证、日志记录、字符编码设置等。
        //
        //修改请求或响应：你可以使用过滤器来修改请求参数、请求头或响应内容。例如，你可以在请求到达 Servlet 之前对请求参数进行解密，或者在响应被发送到客户端之前对其进行压缩。
        //
        //访问控制：通过过滤器，你可以进行访问控制，例如检查用户是否已登录并有权访问某个资源。
        //
        //日志记录：你可以使用过滤器记录请求和响应的详细信息，以便进行故障排除或分析。
        //
        //字符编码设置：你可以在过滤器中设置字符编码，以确保请求和响应中的文本正确地处理。
        //
        //性能优化：过滤器可以用于执行性能优化任务，例如缓存响应内容以减轻服务器负载。
    }
}
