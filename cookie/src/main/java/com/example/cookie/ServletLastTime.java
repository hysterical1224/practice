package com.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "ServletLastTime", value = "/ServletLastTime")
public class ServletLastTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        //2.遍历cookie数组
        System.out.println(cookies.length);
        System.out.println(cookies!=null);
        if(cookies.length > 1) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write( "<h1>欢迎回来，你上次访问时间为;"+value+"</h1>");
                    //重置一下cookie的时间
                    cookie.setMaxAge(60*60*12);
                    cookie.setValue(str_date);
                    response.addCookie(cookie);
                    break;

                    //3.获取cookie的名称:
                    // 4.判断名称是否是: lastTime
                    // //有该Cookie，不是第一次访问
                    //设置Cookie的value//获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    //响应数据
                }

            }

        }

        if (cookies==null||cookies.length==0 || flag==false){

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");

            Cookie cookie = new Cookie("lastTime",str_date);
//            cookie的时候值中存在空格字符,An invalid character [32] was present in the Cookie value
//            确保在设置 Cookie 时没有包含任何不必要的空格或其他特殊字符。确保 Cookie 值是有效的字符串。
            //
            //编码 Cookie 值： 如果您要设置的 Cookie 值包含特殊字符或空格，您可以考虑使用 URL 编码来编码该值，
            // 然后在读取 Cookie 时进行解码。Java 中有 URLEncoder 和 URLDecoder 类可供使用。


            cookie.setMaxAge(60*60*12);
            response.addCookie(cookie);
            response.getWriter().write("<h1>你好，欢迎您首次访问</h1>");
        }

    }
}
