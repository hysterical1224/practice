package service.Impl;

import dao.impl.UserDaoImpl;
import dao.UserDao;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return ud.findAll();
    }
}
