package servlet;

import service.impl.provinceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "provinceServlet", value = "/provinceServlet")
public class provinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        provinceServiceImpl ps = new provinceServiceImpl();
        String provinces = ps.findAllJson();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(provinces);
    }
}
