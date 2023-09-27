package day03;

import java.sql.*;

public class jdbc {

    public static void main(String[] args) throws Exception {
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu", "root", "4ay6V638");
        String sql = "select * from emp";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String name = resultSet.getString("ename");
            System.out.println(name);
        }
        statement.close();
        conn.close();

    }


}
