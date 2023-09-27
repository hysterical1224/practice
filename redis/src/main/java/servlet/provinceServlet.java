package servlet;



import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.impl.ProvinceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "provinceServlet", value = "/provinceServlet")
public class provinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceServiceImpl ps = new ProvinceServiceImpl();


//        List<Province> provinces = ps.findAll();
//
//        ObjectMapper om = new ObjectMapper();
//        String s = om.writeValueAsString(provinces);
//        System.out.println(s);
//
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(s);


        String allJson = ps.findAllJson();

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(allJson);

    }
}
