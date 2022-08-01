package com.example.books.dao.impl;

import com.example.books.dao.UserDao;
import com.example.books.pojo.user;

/**
 * @author YUChangcan
 * @date 2022/7/29 - 18:44
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public user queryUserByUserName(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(user.class,sql,username);
    }

    @Override
    public int saveUser(user user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public user queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return this.queryForOne(user.class,sql,username,password);
    }
}
