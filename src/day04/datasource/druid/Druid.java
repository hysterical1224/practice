package day04.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid {


    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        ClassLoader cld = Druid.class.getClassLoader();
        InputStream resource = cld.getResourceAsStream("day04/datasource/druid/druid.properties");
        pro.load(resource);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }
}
