package day03.Login;

import day03.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCLogin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();

        System.out.println("请输入密码:");
        String password = sc.nextLine();
        boolean lg = new JDBCLogin().login2(username, password);

        if (lg){
            System.out.println("登录成功！");

        } else {
            System.out.println("用户名或密码不正确！");

        }

    }

    public boolean login2(String user, String password){
        if (user==null || password==null){
            return false;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name= ? and password=?";
            System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2,password);
            boolean ex = stmt.execute();
            //            System.out.println(ex);
            return ex;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);

        }
        return false;


    }


    public boolean login(String user, String password){
        if (user==null || password==null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name='"+user+"'and password='"+password+"'";
            System.out.println(sql);
            stmt = conn.createStatement();
            boolean ex = stmt.execute(sql);
//            System.out.println(ex);
            return ex;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);

        }
        return false;


    }
}
