package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "FilterDemo1",value = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo1被执行了。。。。");
        chain.doFilter(request, response);
        //        	* 拦截路径配置：
        //			1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
        //			2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
        //			3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
        //			4. 拦截所有资源：/*		访问所有资源时，过滤器都会被执行


        //        * 拦截方式配置：资源被访问的方式
        //                * 注解配置：
        //				* 设置dispatcherTypes属性
        //        1. REQUEST：默认值。浏览器直接请求资源
        //        2. FORWARD：转发访问资源
        //        3. INCLUDE：包含访问资源
        //        4. ERROR：错误跳转资源
        //        5. ASYNC：异步访问资源


    }
}
