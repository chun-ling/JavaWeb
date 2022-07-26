package com.example.books.dao.impl;

import com.example.books.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author YUChangcan
 * @date 2022/7/29 - 18:14
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();
    public int update(String sql,Object ...args){
        Connection connecton = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connecton,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connecton);
        }
        return -1;
    }
    public <T>T queryForOne(Class<T> type,String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
             return queryRunner.query(connection,sql,new BeanHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    public <T>List<T> queryForList(Class<T>type, String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    public Object queryForSingleValue(String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
