package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin",value = "/*")
public class FilterLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
//        是否包含登陆相关资源路径
        if (uri.contains("/login.jsp")||uri.contains("/Login")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCodeServlet")){
            //包含，用户想要登录，放行
            chain.doFilter(request, response);
        } else {
            //不包含，需要验证用户是否登录
            //从session中获取user
            Object user = req.getSession().getAttribute("user");
            if (user!=null){
                //登录了，放行
                chain.doFilter(req,response);

            }else {
                //没有登录，跳转登录页面
                req.setAttribute("login_msg","您尚未登录，请登录");
                req.getRequestDispatcher("login.jsp").forward(req,response);
            }
        }


    }
}
