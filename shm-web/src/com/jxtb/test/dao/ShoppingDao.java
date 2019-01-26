package com.jxtb.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.dao.BaseDao;
import com.core.dao.JDBCBaseDao;
import com.jxtb.test.entity.Product;
import com.jxtb.test.entity.Test;
import org.hibernate.SQLQuery;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

//超市商品信息管理
@Repository("shoppingDao")
public class ShoppingDao extends SqlSessionDaoSupport {

    //查询所有商品信息
    public List<Product> getAllProducts() {
        ResultSet rs;
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            rs = JDBCBaseDao.query(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String factory = rs.getString("factory");
                String baoZhi = rs.getString("baoZhi");
                int saleNum = rs.getInt("salenum");
                Product stu = new Product(id, name, price, factory, baoZhi, saleNum);
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 导出
     * @return
     */

    public List<Map<String, String>> getDataLists() {
        return getSqlSession().selectList("jxtbTest.exportGetDataLists");
    }


}
