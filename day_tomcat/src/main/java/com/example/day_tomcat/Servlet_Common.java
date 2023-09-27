package com.example.day_tomcat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "Servlet_Common", value = "/Servlet_Common")
public class Servlet_Common extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("get:");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("post:");
        System.out.println(username);

        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby:hobbies){
            System.out.println(hobby);
        }

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());

        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String s : parameterMap.keySet()) {
            for (String s1 : parameterMap.get(s)) {
                System.out.println(s1);
            }
        }

    }
}
