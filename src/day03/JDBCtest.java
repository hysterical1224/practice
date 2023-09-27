package day03;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCtest {


    public static void main(String[] args) {
        List<Emp> list1 = new JDBCtest().findAll();
        System.out.println(list1);
        System.out.println(list1.size());

    }

    public List<Emp> findAll(){
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);
            Emp emp = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                int mgr = rs.getInt("mgr");
//                System.out.println(ename);
                // 创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合

                list.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);

        }
        return list;


    }
}
