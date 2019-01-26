package com.jxtb.test.dao.impl;

import com.jxtb.test.dao.MyBatisDao;
import com.jxtb.test.entity.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午1:49
 * To change this template use File | Settings | File Templates.
 */
@Repository("myBatisDao")
public class MyBatisDaoImpl extends SqlSessionDaoSupport implements MyBatisDao {
    @Override
    public List<Test> getAllUser() {
        List<Test> list=getSqlSession().selectList("jxtbTest.getAllTest");
        return list;
    }

    @Override
    public int addTestInfo(Test test) {
        return getSqlSession().insert("jxtbTest.insert",test);
    }

    @Override
    public int deleteTestInfo(Test test) {
        return getSqlSession().delete("jxtbTest.delete",test);
    }

    @Override
    public int updateTestInfo(Test test) {
        return getSqlSession().update("jxtbTest.update",test);
    }
}
