package day04.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0 {

    public static void main(String[] args) {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            for (int i=1;i<=11;i++){
                Connection conn = ds.getConnection();
                System.out.println(i+":"+conn);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
