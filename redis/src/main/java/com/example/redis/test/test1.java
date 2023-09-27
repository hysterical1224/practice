package com.example.redis.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import service.impl.ProvinceServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class test1 {

    @Test
    public void testRowMapper(){
        ProvinceServiceImpl ps = new ProvinceServiceImpl();
        List<Province> provinces = ps.findAll();

        ObjectMapper om = new ObjectMapper();
        String s = null;
        try {
            s = om.writeValueAsString(provinces);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
    @Test
    public void testJedisPool(){
         JedisPool jedisPool;

        InputStream rs = Jedis.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关联数据
        JedisPoolConfig jpc = new JedisPoolConfig();


        jpc.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jpc.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //初始化jedis
        jedisPool = new JedisPool(jpc, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
        Jedis jd = jedisPool.getResource();
        String name = jd.get("name");
        System.out.println(name);


    }
}
