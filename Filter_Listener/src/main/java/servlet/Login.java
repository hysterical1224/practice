package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //        获取完session中的验证码，就需要删除验证码，防止验证码重复使用
        session.removeAttribute("checkCode_session");

        //        判断验证码是否正确
        if (checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){
            //            登录成功
            if ("zhangsan".equals(username)&& "123".equals(password)){


                session.setAttribute("user",username);
                response.sendRedirect( request.getContextPath()+"/Servlet_UserList");

            }else {
                //登录失败
                request.setAttribute("login_error","用户名或密码的错误");
                request.getRequestDispatcher("/case/login.jsp").forward(request,response);

            }

        } else {
            request.setAttribute("login_error","验证码不能为空");
            request.getRequestDispatcher("/case/login.jsp").forward(request,response);
        }
    }
}
