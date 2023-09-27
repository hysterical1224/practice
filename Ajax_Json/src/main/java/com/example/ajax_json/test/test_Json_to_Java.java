package com.example.ajax_json.test;

import com.example.ajax_json.domain.user;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class test_Json_to_Java {


    @Test
    public void testjj(){
        String json = "{\"age\":12,\"gender\":\"male\",\"birthday\":\"2023-09-19 03:21:52\",\"fullName\":\"zhangsan\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            user user = objectMapper.readValue(json, user.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //        ObjectMapper objectMapper = new ObjectMapper();
        //
        //        try {
        //            // 读取 JSON 文件并解析为 Java 对象
        //            List<User> users = objectMapper.readValue(new File("users.json"), new TypeReference<List<User>>() {});
        //            // 打印 Java 对象
        //            for (User user : users) {
        //                System.out.println(user);
        //            }
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
        //    }

    }
    @Test
    public void testjj2(){
        ObjectMapper objectMapper = new ObjectMapper();
        
    }
}
