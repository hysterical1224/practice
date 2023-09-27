package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "FilterSensitiveWords",value = "/*")
public class FilterSensitiveWords implements Filter {
    private List<String> list = new ArrayList<>();
//    敏感词汇集合
    public void init(FilterConfig config) throws ServletException {
//        获得ServletContext

        try {
//            ServletContext servletContext = config.getServletContext();
//
//            String realPath = servletContext.getRealPath("../classes/敏感词汇.txt");
//            System.out.println(realPath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FilterSensitiveWords.class.getClassLoader().getResourceAsStream("敏感词汇.txt"),"UTF-8"));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                System.out.println("---------------------");
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxyRequest = (ServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    //                    获取返回值
                    String value = (String) method.invoke(request, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request, args);
            }
        });


        chain.doFilter(proxyRequest, response);
    }
}
