package dao.impl;

import dao.provinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class provinceImpl implements provinceDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDs());

    @Override
    public List<Province> getAllProvince() {
        String sql = "select * from province";
        List<Province> res = jt.query(sql, new BeanPropertyRowMapper<>(Province.class));

        return res;

    }
}
