package com.example.ajax_json.test;


import com.example.ajax_json.domain.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.core.SpringVersion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class testJson_User {

    @Test
    public void test1(){
        user user = new user();
        user.setName("zhangsan");
        user.setAge(12);
        user.setGender("male");
        user.setBirthday(new Date());

        //要将 Java 类转换为 JSON，你可以使用 Jackson 库，它提供了简单而强大的方法来执行这项任务。以下是一个基本的步骤：
        //
        //导入 Jackson 库：首先，确保你的 Java 项目中包含了 Jackson 库。
        //你可以将 Jackson 核心库和数据绑定库添加到你的项目依赖中，例如使用 Maven 或 Gradle。
        //
        //创建 Java 对象：定义一个 Java 类，该类的实例将被转换为 JSON。确保该类具有与 JSON 属性相对应的字段。
        //
        //使用 Jackson 库转换为 JSON：
        //对象转为 JSON 字符串：使用 Jackson 的 ObjectMapper 类将 Java 对象转换为 JSON 字符串。

        //ObjectMapper 对象是为了使用 Jackson 库的功能来进行 Java 对象与 JSON 数据之间的转换。
        //ObjectMapper 是 Jackson 库中的核心类，它负责处理序列化（将 Java 对象转换为 JSON）和反序列化（将 JSON 转换为 Java 对象）操作。

        ObjectMapper objectMapper = new ObjectMapper();

        //进行转换
        //objectMapper.writeValue() 方法是 Jackson 库中的一个重要方法，用于将 Java 对象转换为 JSON 数据。
        //这个方法有不同的重载形式，以满足不同的需求，但其基本用法是将一个 Java 对象序列化为 JSON 字符串或将其写入输出流中。

        //   参数1：
        //File：将obj对象转换为JSON字符串，并保存到指定的文件中
        //Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
        //OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中

        //ObjectMapper objectMapper = new ObjectMapper();
        //Writer writer = new FileWriter("output.json");
        //objectMapper.writeValue(writer, yourJavaObject);
        //writer.close();
        try {
            System.out.println(user);
            String s = objectMapper.writeValueAsString(user);
            System.out.println(s);
            objectMapper.writeValue(new FileWriter("d://b.json"),user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ObjectMapper objectMapper = new ObjectMapper();
        //String jsonString = objectMapper.writeValueAsString(yourJavaObject);
        //这将 yourJavaObject 转换为 JSON 字符串，并将其存储在 jsonString 变量中。



    }


    @Test
    public void test2(){
        user user = new user();
        user.setName("zhangsan");
        user.setAge(12);
        user.setGender("male");
        user.setBirthday(new Date());

        user user1 = new user();
        user1.setName("lisi");
        user1.setAge(12);
        user1.setGender("female");
        user1.setBirthday(new Date());
        List<user> ls = new ArrayList<>();
        ls.add(user);
        ls.add(user1);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String s = objectMapper.writeValueAsString(ls);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testVersion(){
        String version = SpringVersion.getVersion();

//        String version1 = SpringBootVersion.getVersion();

        System.out.println(version);

//        System.out.println(version1);

    }

}
