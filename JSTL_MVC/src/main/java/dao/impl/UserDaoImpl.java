package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;


import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDs());
    @Override
    public List<User> findAll() {
        String sql = "select * from user_el";
        List<User> query = jt.query(sql, new BeanPropertyRowMapper<>(User.class));
        return query;

    }
}
