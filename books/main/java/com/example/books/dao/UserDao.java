package com.example.books.dao;

import com.example.books.pojo.user;

/**
 * @author YUChangcan
 * @date 2022/7/29 - 18:36
 */
public interface UserDao {
    public user queryUserByUserName(String username);

    /**
     *
     * @param user
     * @return 若返回-1，则查询失败
     */
    public int saveUser(user user);
    public user queryUserByUsernameAndPassword(String username,String password);
}
