package day03.Login;

import day03.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controlshiwu {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {

            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update account set balance=balance-? where id=?";
            String sql2 = "update account set balance=balance+? where id=?";
            stmt1 = conn.prepareStatement(sql1);
            stmt2 = conn.prepareStatement(sql2);
            stmt1.setDouble(1, 500);
            stmt1.setInt(2,1);
            stmt2.setDouble(1,500);
            stmt2.setInt(2,2);

            int i = stmt1.executeUpdate();
            float q = 3/0;

            int i1 = stmt2.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } finally {
            JDBCUtils.close(stmt1,conn);
            JDBCUtils.close(stmt2,null);
        }
    }

}
