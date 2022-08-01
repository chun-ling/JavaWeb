package com.example.books.service;

import com.example.books.pojo.user;

/**
 * @author YUChangcan
 * @date 2022/7/30 - 8:04
 */
public interface UserService {
    public void registUser(user user);
    public user login(user user);
    public boolean existsUsername(String username);
}
