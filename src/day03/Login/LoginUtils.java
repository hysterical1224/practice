package day03.Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginUtils {
    Connection conn =null;

    static {

    }

    public static void close(Statement stmt, Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null) {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
