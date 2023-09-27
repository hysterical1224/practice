import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import utils.JedisPoolUtils;

public class JedisTest {

    //JedisPoolUtils的测试
    @Test
    public void test1(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String name = jedis.set("ssname", "宋伸");
        System.out.println(name);
        String s = jedis.get("ssname");
        System.out.println(s);
    }
}
