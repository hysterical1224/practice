package day04.datasource.jdbcTemplate;

import day04.datasource.druid.DruidUtils;
import day04.datasource.jdbcTemplate.domain.Emp;
import day04.datasource.jdbcTemplate.domain.Emp_rollMapper;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jdbcTmpDemo {
    private JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDataSource());

    @Test
    public void test(){

        String sql = "update emp set salary=10000 where id=?";
        int count = jt.update(sql, 1001);
        System.out.println(count);
    }

    @Test
    public void testInsert(){
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        Object[] args = {1015,"郭靖",10};
        int count = jt.update(sql, args);
        System.out.println(count);
    }

    @Test
    public void TestDel(){
        String sql = "delete from emp where id=?";
        Object[] args = {1015};

        int count = jt.update(sql, args);
        System.out.println(count);
    }

//    @Test
//    public void TestInsert2(){
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", 1015);
//        paramMap.put("ename", "郭靖");
//        paramMap.put("dept_id", 10);
//
//        String sql = "insert into emp(id, ename, dept_id) values(:id, :ename, :dept_id)";
//        int count = jt.update(sql, paramMap);
//        System.out.println(count);
//    }

    @Test
    public void testMap(){
        String sql = "select * from emp where id=?";
        Object[] args ={1001};
        Map<String ,Object> result = jt.queryForMap(sql,args);
        System.out.println(result);
    }

    @Test
    public void testList(){
        /**
         *queryForList 返回一个 List，每个元素是一个 Map 对象，适用于将结果集映射为 Map 对象列表。
         * */
        String sql ="select * from emp";
        List<Map<String, Object>> jtl = jt.queryForList(sql);
        for (Map<String, Object> stringObjectMap:jtl) {
            System.out.println(stringObjectMap);
        }
    }

    @Test
    public void testRowMapper(){
        /**
         * query 返回一个 List，每个元素是一个 JavaBean 对象，适用于将结果集映射为 JavaBean 对象列表。
         * */
        String sql = "select * from emp";
        List<Emp_rollMapper> query = jt.query(sql, new BeanPropertyRowMapper<>(Emp_rollMapper.class));
        for (Emp_rollMapper e:query){
            System.out.println(e);
        }

    }

    @Test
    public void testRecord(){
        /**
         * 用途：执行查询操作，返回单个结果对象。
         * 适用范围：当你需要查询返回单个结果对象时使用，
         * 比如查询一个特定的实体对象或者聚合函数的结果（如 COUNT、SUM 等）。
         * 注意：如果查询结果为空，或者查询结果超过一个对象，
         * queryForObject 方法将会抛出 EmptyResultDataAccessException
         * 或 IncorrectResultSizeDataAccessException 异常。
         * */
        String sql="select count(*) from emp";
        Long total = jt.queryForObject(sql, Long.class);
        /**
         * 当你需要查询单个结果对象，并且结果对象是一个 JavaBean（POJO），
         * 并且数据库字段与 JavaBean 属性名称一致时，可以选择使用 queryForObject 方法，
         * 并传入结果对象的 Class 类型。
         *
         * */
        System.out.println(total);



    }






}
