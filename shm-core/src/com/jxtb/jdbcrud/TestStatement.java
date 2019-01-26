package com.jxtb.jdbcrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.core.dao.JDBCBaseDao;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
public class TestStatement {
    private static Logger logger = Logger.getLogger(TestStatement.class.getName());
    public static void main(String[] args) {
        TestStatement.insert();
        //TestStatement.update();
        //TestStatement.search();
        //TestStatement.delete();
    }
    /**
     * Statement插入
     */
    public static void insert(){
        Connection conn = null;
        Statement stmt = null;
        // 1、加载驱动
        try {
            // 2、建立连接
            conn = JDBCBaseDao.getConnection();
            // 3、插入狗狗信息到数据库
            stmt = conn.createStatement();
            StringBuffer sbSql = new StringBuffer(
                    "INSERT INTO cbd_test(id,userName,userPsw) values(REPLACE(UUID(),'-',''),'jxtb','jxtb')");
            stmt.execute(sbSql.toString());
            logger.info("插入狗狗信息成功！");
            System.out.println("插入狗狗信息成功！");
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            // 4、关闭Statement和数据库连接
           JDBCBaseDao.closeAll(conn,stmt,null);
        }
    }
    /**
     *更新
     */
    public static void update(){
        Connection conn = null;
        Statement stmt = null;
        // 1、加载驱动
        try {
            // 2、建立连接
            conn = JDBCBaseDao.getConnection();
            // 3、更新狗狗信息到数据库
            stmt = conn.createStatement();
            stmt.executeUpdate("update cbd_test set userPsw='admin' where userName='jxtb'");
            logger.info("成功更新狗狗信息！");
            System.out.println("成功更新狗狗信息！");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            // 4、关闭Statement和数据库连接
            JDBCBaseDao.closeAll(conn,stmt,null);
        }
    }
    /**
     * 查询
     */
    public static void search(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // 1、加载驱动
        try {
            // 2、建立连接
            conn = JDBCBaseDao.getConnection();
            // 3、查询并输出狗狗信息
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from cbd_test");
            System.out.println("\t\t用户信息列表");
            System.out.println("编号\t姓名\t密码");
            while (rs.next()) {
                System.out.print(rs.getString(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3) + "\t");
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            // 4、关闭Statement和数据库连接
            JDBCBaseDao.closeAll(conn,stmt,rs);
        }
    }
    /**
     * 删除
     */
    public static void delete(){
        Connection conn = null;
        Statement stmt = null;
        // 1、加载驱动
        try {
            // 2、建立连接
            conn = JDBCBaseDao.getConnection();
            // 3、插入狗狗信息到数据库
            stmt = conn.createStatement();
            String sbSql="delete from cbd_test where userName='jxtb'";
            stmt.execute(sbSql);
            logger.info("删除狗狗信息成功！");
            System.out.println("删除狗狗信息成功！");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            // 4、关闭Statement和数据库连接
            JDBCBaseDao.closeAll(conn,stmt,null);
        }
    }
}

