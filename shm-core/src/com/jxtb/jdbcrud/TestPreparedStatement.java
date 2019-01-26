package com.jxtb.jdbcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.core.dao.JDBCBaseDao;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public class TestPreparedStatement {
    private static Logger logger = Logger.getLogger(TestPreparedStatement.class.getName());
    public static void main(String[] args) {
        TestPreparedStatement.update();

    }
    /**
     * 更新
     */
    public static void update(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1、加载驱动
        try {
            // 2、建立连接
            conn = JDBCBaseDao.getConnection();
            // 3、更新狗狗信息到数据库
            String sql="update cbd_test set userPsw=? where userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "admin");
            pstmt.setString(2, "jxtb");
            pstmt.executeUpdate();
            logger.info("成功更新狗狗信息！");
            System.out.println("成功更新狗狗信息！");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            // 4、关闭Statement和数据库连接
            try {
                if (null != pstmt) {
                    pstmt.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }
}
