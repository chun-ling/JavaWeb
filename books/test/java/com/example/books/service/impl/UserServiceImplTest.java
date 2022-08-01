package com.example.books.service.impl;

import com.example.books.pojo.user;
import com.example.books.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUChangcan
 * @date 2022/7/30 - 8:14
 */
class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    void registUser() {
        userService.registUser(new user(null,"nihao","000999","tt@1233.com"));
        userService.registUser(new user(null,"Jonh","911","American@1233.com"));
    }

    @Test
    void login() {
        System.out.println(userService.login(new user(null,"Jonh","911","American@44.com")));
    }

    @Test
    void existsUsername() {
        if(userService.existsUsername("Jonh")){
            System.out.println("用户名已存在");
        }else
            System.out.println("用户名可用");
    }
}