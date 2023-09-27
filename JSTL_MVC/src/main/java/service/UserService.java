package service;

import domain.User;

import java.util.List;

public interface UserService {

    /*
    * 查询所以用户信息
    * */
    public List<User> findAll();
}
