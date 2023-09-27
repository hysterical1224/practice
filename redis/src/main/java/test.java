import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {

    @Test
    public void test1(){
        Jedis jd = new Jedis("localhost", 6379);
        String jset = jd.set("username1", "zhangsan");
        //返回OK

        System.out.println(jset);
        jd.setex("acrivecode", 20, "hello?");
//        将activecode：hello？键值对存入redis，20秒后自动删除该键值对


        jd.close();


    }


    @Test
    public void test2(){
        Jedis jd = new Jedis("localhost", 6379);
        Long jset = jd.hset("user","name","宋伸");
        //返回1
        jd.hset("user","age","12");
        jd.hset("user", "gender", "male");

        String name = jd.hget("user", "name");
        System.out.println(name);


        System.out.println(jset);
        jd.setex("acrivecode", 20, "hello?");
        //        将activecode：hello？键值对存入redis，20秒后自动删除该键值对

        Map<String, String> users = jd.hgetAll("user");
        for (Map.Entry<String, String> entry : users.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);
        }

        jd.close();


    }



    @Test
    public void test3(){
        Jedis jd = new Jedis("localhost", 6379);
       jd.lpush("ls","b","c","a");
       jd.rpush("ls","b","c","a");
        List<String> ls = jd.lrange("ls", 0, -1);
        System.out.println(ls);

        String ele1 = jd.lpop("ls");
        String ele2 = jd.rpop("ls");
        List<String> ls1 = jd.lrange("ls", 0, -1);
        System.out.println(ls1);

        jd.close();

    }


    @Test
    public void test4(){
        Jedis jd = new Jedis("localhost", 6379);

        Long sadd = jd.sadd("ms", "java", "php", "C++");
        System.out.println(sadd);

        Set<String> ms = jd.smembers("ms");
        System.out.println(ms);

        jd.close();

    }

    @Test
    public void test5(){
        Jedis jd = new Jedis("localhost", 6379);

        Long sadd = jd.zadd("枪械",40,"火麒麟");
        jd.zadd("枪械",30,"沙漠之鹰");
        jd.zadd("枪械", 80,"98K");

        Set<String> 枪械 = jd.zrange("枪械", 0, -1);
        System.out.println(枪械);


        jd.close();

    }
}
