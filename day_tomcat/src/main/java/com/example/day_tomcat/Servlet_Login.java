package com.example.day_tomcat;

import com.example.dao.UserDao;
import com.example.domain.User;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Servlet_Login", value = "/Servlet_Login")
public class Servlet_Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编写login.html登录页面
        //username & password 两个输入框
        //2使用Druid数据南连接池技术,操作mysql，day14数据库中user表
        //3使用JdbcTemplate技术封装JDBC
        //4.登录成功跳转到successservlet展示:登录成功!用户名，欢迎您5.登录失败跳转到Failservlet展示:登录失败，用户名或密码错误
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String s:keys){
            String[] values= parameterMap.get(s);
            for (int i=0;i< values.length;i++)
            System.out.println(values[i]);
        }

        User us = new User();


        try {
            BeanUtils.populate(us,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //BeanUtils.populate 方法需要保证属性名和 parameterMap 中的键相匹配，以便正确地填充属性值。属性名的大小写以及属性名的映射规则都要符合。
        //如果属性的数据类型不匹配，会尝试进行自动类型转换，但如果类型转换失败，可能会导致异常。
        //这个方法是通过 Java 反射实现的，可以自动调用 JavaBean 的相应 setter 方法。
        System.out.println(us);

        UserDao userDao = new UserDao();
        List<User> msg = userDao.login(us);
        System.out.println("-----------------");
        for (User user : msg) {
            System.out.println(msg.get(0));
        }


        if (msg==null){
//            登录失败
            request.getRequestDispatcher("fail_Servlet").forward(request,response);
        } else {
//            登录成功
            request.setAttribute("user",msg.get(0));
            request.getRequestDispatcher("success_Servlet").forward(request,response);
        }


//        BeanUtils.setProperty、BeanUtils.getProperty 和 BeanUtils.populate 都是 Apache Commons BeanUtils 库提供的方法，
        //        用于在 JavaBean 对象和 Map（通常是请求参数）之间进行属性值的设置、获取和映射。
        //
        //BeanUtils.setProperty(Object bean, String name, Object value):
        //
        //作用：将指定的值设置到 JavaBean 对象的指定属性上。
        //参数：
        //bean: 目标 JavaBean 对象。
        //name: 要设置的属性名。
        //value: 要设置的属性值。
        //这个方法通过 Java 反射调用目标对象的 setter 方法来设置属性值。
        //BeanUtils.getProperty(Object bean, String name):
        //
        //作用：从 JavaBean 对象中获取指定属性的值。
        //参数：
        //bean: 目标 JavaBean 对象。
        //name: 要获取值的属性名。
        //返回：属性的值。
        //这个方法通过 Java 反射调用目标对象的 getter 方法来获取属性值。
        //BeanUtils.populate(Object bean, Map<String, ? extends Object> properties):
        //
        //作用：将 Map 中的键值对映射到 JavaBean 对象的属性上。
        //参数：
        //bean: 目标 JavaBean 对象。
        //properties: 包含属性名和属性值的 Map。
        //这个方法会根据 Map 中的键值对，自动匹配属性名并将对应的值填充到 JavaBean 对象的属性中。
        //这些方法在处理 JavaBean 和属性映射的过程中非常有用，尤其是在处理表单提交数据时。
        // 例如，可以使用 BeanUtils.populate 将请求参数自动映射到 JavaBean 对象的属性上，
        // 而无需手动编写大量的属性设置代码。使用 BeanUtils.getProperty 和 BeanUtils.setProperty
        // 可以方便地获取和设置属性值，避免了繁琐的反射操作。



    }
}
