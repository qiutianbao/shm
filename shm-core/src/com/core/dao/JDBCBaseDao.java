package com.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 上午11:12
 * 数据库连接与关闭工具类。
 */
public class JDBCBaseDao {
    public static Logger log = Logger.getLogger(BaseDao.class.getName());
    private static String driver =
            "com.mysql.jdbc.Driver";// 数据库驱动字符串
    private static String url =
            "jdbc:mysql://localhost:3306/jxtb?useUnicode=true&amp;characterEncoding=utf-8";// 连接URL字符串
    private static String user = "root"; // 数据库用户名
    private static String password = "123456"; // 用户密码
    private static	Connection conn = null;// 数据连接对象

    protected ResultSet rs;
    protected PreparedStatement stmt;

    /**
     * 获取数据库连接对象。
     */
    public static Connection getConnection() {
        if(conn==null){
            // 获取连接并捕获异常
            try {
                // 加载驱动
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                //log.debug("数据库连接成功!");
            } catch (Exception e) {
                e.printStackTrace();// 异常处理
                //log.debug("数据库连接失败!");
            }
        }
        return conn;// 返回连接对象
    }
    /**
     * 执行查询操作
     * @return ResultSet
     */
    public static ResultSet query(String sql) {
        PreparedStatement pstmt;
        ResultSet rs=null;
        try {
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }
    /**
     *  执行查询操作根据Id号
     * @return ResultSet
     */
    public static ResultSet queryById(String sql,String id) {
        PreparedStatement pstmt;
        ResultSet rs=null;
        try {
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }

    /**
     * 查询总记录数
     * @return  总记录数
     */
    public static int rowCount(String sql){
        int result=0;
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                result++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 关闭数据库连接。
     * @param conn 数据库连接
     * @param stmt Statement对象
     * @param rs 结果集
     */
    public static void closeAll(Connection conn, Statement stmt,
                         ResultSet rs) {
        try{
            // 若结果集对象不为空，则关闭
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 若Statement对象不为空，则关闭
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 若数据库连接对象不为空，则关闭
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            log.error(e);
        }

    }
    /**
     * 增、删、改的操作
     * @param preparedSql 预编译的 SQL 语句
     * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组
     * @return 影响的行数
     */
    public int executeUpdate(String preparedSql, Object[] param) {
        PreparedStatement pstmt;
        int num = 0;
        conn =  getConnection();
        try {
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    //创建PreparedStatement对象
    private void createPrepareStatement(String sql, Object[] parameters) throws SQLException {
        stmt = conn.prepareStatement(sql);
        if(parameters != null){
            for(int i=0; i<parameters.length; i++){
                stmt.setObject(i+1, parameters[i]);
            }
        }
    }

    //执行增删改的操作
    public boolean executeAddDeleteUpdate(String sql, Object[] parameters) throws SQLException{
        createPrepareStatement(sql, parameters);
        int result = stmt.executeUpdate();
        return result>0;
    }

    //执行查询的操作
    public ResultSet executeQuery(String sql, Object[] parameters) throws SQLException{
        createPrepareStatement(sql, parameters);
        rs = stmt.executeQuery();
        return rs;
    }

}

