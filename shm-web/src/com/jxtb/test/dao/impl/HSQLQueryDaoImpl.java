package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.HSQLQueryDao;
import com.jxtb.test.entity.Test;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Repository("hsqlQueryDao")
public class HSQLQueryDaoImpl extends BaseDao<Test> implements HSQLQueryDao {

    public List<Test> findAllTest() {
        SQLQuery sqlQuery=getSession().createSQLQuery("select * from cbd_test");
        return sqlQuery.list();
    }

}
