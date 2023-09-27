package day04.datasource.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class druidDemo {


    public static void main(String[] args) {


        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DruidUtils.getConnection();
            String sql = "insert into account values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"王五");
            pstm.setInt(2,2000);
            int i = pstm.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(conn, pstm);
        }
    }
}
