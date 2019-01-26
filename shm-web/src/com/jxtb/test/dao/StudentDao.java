package com.jxtb.test.dao;

import com.core.dao.JDBCBaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-8-5
 * Time: 上午8:28
 * To change this template use File | Settings | File Templates.
 */
public class StudentDao {
    public static List<HashMap<String,Object>> findStudents(){
        List<HashMap<String,Object>> list=null;
        ResultSet rs;
        String sql="select * from Student";
        try {
            list=new ArrayList<>();
            rs= JDBCBaseDao.query(sql);
            HashMap<String,Object> map=null;
            while (rs.next()){
                map=new HashMap<String,Object>();
                map.put("id",rs.getInt("id"));
                map.put("name",rs.getString("name"));
                map.put("pwd",rs.getString("pwd"));
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
