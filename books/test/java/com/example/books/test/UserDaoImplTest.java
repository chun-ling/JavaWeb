package com.example.books.test;

import com.example.books.dao.UserDao;
import com.example.books.dao.impl.UserDaoImpl;
import com.example.books.pojo.user;
import org.junit.jupiter.api.Test;

/**
 * @author YUChangcan
 * @date 2022/7/29 - 20:39
 */
class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    void queryUserByUserName() {
        if(userDao.queryUserByUserName("admin") == null){
            System.out.println("用户名可用");
        }else
            System.out.println("用户名已存在");
    }

    @Test
    void saveUser() {
        System.out.println(userDao.saveUser(new user(null,"root","123456","111@qq.com")));

    }

    @Test
    void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名密码查询失败");
        }else
            System.out.println("查询成功");
    }
}