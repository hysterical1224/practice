package com.example.ajax_json.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class user {
    @JsonProperty("fullName")
    String name;
    int age;
    String gender;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC")
    private Date birthday;

    //Jackson 库提供了多个注解，用于控制 JSON 序列化和反序列化的行为。以下是一些常用的 Jackson 注解及其作用：
    //
    //@JsonProperty：用于指定 Java 对象字段与 JSON 属性之间的映射关系，可以自定义字段在 JSON 中的名称。

    //public class Person {
    //    @JsonProperty("name")
    //    private String fullName;
    //
    //    // Getter 和 Setter 方法
    //}


    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public user() {
    }

    public String getName() {
        return name;
    }

    public user(String name, int age, String gender, Date birthday) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
