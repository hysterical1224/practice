import com.example.utils.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;

public class testJDBC {

    @Test
    public void conn(){
        DataSource ds = JDBCUtils.getDs();
        InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        System.out.println(rs);
    }
}
