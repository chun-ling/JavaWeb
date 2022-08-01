package com.example.books.service.impl;

import com.example.books.dao.UserDao;
import com.example.books.dao.impl.UserDaoImpl;
import com.example.books.pojo.user;
import com.example.books.service.UserService;

/**
 * @author YUChangcan
 * @date 2022/7/30 - 8:09
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(user user) {
        userDao.saveUser(user);
    }

    @Override
    public user login(user user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUserName(username) == null){
            return false;
        }else
            return true;
    }
}
