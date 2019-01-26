package com.jxtb.jdbcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
public class TestConn {

    private static Logger logger = Logger.getLogger(TestConn.class.getName());

    public static void main(String[] args) {
        TestConn.conn();
    }

    /**
     * 普通链接
     */
    public static void conn(){
        Connection conn = null;
        // 1、加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error(e);
        }
        // 2、建立连接
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jxtb?useUnicode=true&amp;characterEncoding=utf-8",
                    "root", "123456");
            System.out.println("建立连接成功！");
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            // 3、关闭连接
            try {
                if (null != conn) {
                    conn.close();
                    System.out.println("关闭连接成功！");
                }
            } catch (SQLException e) {
                logger.error(e);
                e.printStackTrace();
            }
        }
    }

}
