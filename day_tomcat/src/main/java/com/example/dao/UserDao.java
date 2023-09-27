package com.example.dao;

import com.example.domain.User;
import com.example.utils.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDs());
    //JdbcTemplate 是 Spring 框架提供的数据库操作工具类，
    // 它封装了许多常见的数据库操作，如查询、插入、更新、删除等，使数据库操作更加简单和便捷。
    //
    //JDBCUtils.getDs() 返回一个数据源对象，通常是一个连接池，比如 Druid 数据库连接池。
    // 数据源管理了数据库连接的创建、管理和释放，提高了数据库操作的效率。
    //
    //通过传入数据源对象，创建了一个 JdbcTemplate 实例 jt，这样就可以通过 jt 来执行各种数据库操作，
    // 而不需要手动管理连接的创建和释放。


//    先创建一个domain的User，UserDao用来Servlet和User表的交互

    public List<User> login(User user){
        String sql = "select * from user where username=? and password=?";
//            User user1 = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPwd());
        //将查询结果映射为一个 User 类型的对象。查询的条件是通过 user 对象中的用户名和密码属性提供的，
        // 最终返回一个查询到的 User 对象。
        List<User> userList = jt.query(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
        return userList.isEmpty()? null:userList;


    }
}
