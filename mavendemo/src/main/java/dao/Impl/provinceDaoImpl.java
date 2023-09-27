package dao.Impl;

import dao.provinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.util.List;

public class provinceDaoImpl implements provinceDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDs());


    @Override
    public List<Province> getAllProvince() {
        String sql = "select * from province";
        List<Province> provinces = jt.query(sql, new BeanPropertyRowMapper<>(Province.class));

        return provinces;
    }
}
