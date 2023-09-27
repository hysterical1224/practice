import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.Test;

import java.util.List;

public class testUser {

    @Test
    public void testUser(){
        User user = new User();
        user.setUsername("ss");
        user.setPassword("123");


        UserDao dao = new UserDao();
        List<User> login = dao.login(user);
        System.out.println(login);


    }
}
