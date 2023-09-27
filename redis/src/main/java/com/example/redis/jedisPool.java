package com.example.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class jedisPool {

    @Test
    public void testJP(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        //jedisPoolConfig.setMaxTotal(50);: 设置连接池的最大连接数为 50，
        // 表示同时可以有最多 50 个连接到 Redis 的客户端。

        //jedisPoolConfig.setMaxIdle(10);: 设置连接池的最大空闲连接数为 10，
        // 表示连接池中最多可以保持 10 个空闲连接。


        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        String rs = jedis.set("name", "呀哈哈");
        System.out.println(rs);
        String s = jedis.get("name");
        System.out.println(s);

        jedis.close();
    }


}
