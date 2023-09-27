package day04.datasource.jdbcTemplate;

import day04.datasource.druid.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JDBCTemplateDemo {

    public static void main(String[] args) {

        DataSource ds = DruidUtils.getDataSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "update account set balance=5000 where id=?";
        int count = jt.update(sql, 3);
        System.out.println(count);


    }
}
