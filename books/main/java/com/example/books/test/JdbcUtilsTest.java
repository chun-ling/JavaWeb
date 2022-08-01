package com.example.books.test;

import com.example.books.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;


/**
 * @author YUChangcan
 * @date 2022/7/29 - 17:55
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for(int i = 0;i < 100;i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
