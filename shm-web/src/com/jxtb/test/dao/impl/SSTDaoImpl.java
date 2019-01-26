package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.SSTDao;
import com.jxtb.test.entity.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Repository("sstDao")
public class SSTDaoImpl extends BaseDao<Test> implements SSTDao {

    @Override
    public List<Test> findAllTest() {
        return getSqlSessionTemplate().selectList("jxtbTest.getAllTest");
    }

    @Override
    public int savTest(Test test) {
        return getSqlSessionTemplate().insert("jxtbTest.insert", test);
    }

    @Override
    public Test queryTestById(HashMap<String, Object> map) {
        return getSqlSessionTemplate().selectOne("jxtbTest.get", map);
    }

    @Override
    public int findTotalCount() {
        return getSqlSessionTemplate().selectOne("jxtbTest.getAllCount");
    }

    @Override
    public int updateTest(Test test) {
        int result=0;
        try {
            getSqlSessionTemplate().update("jxtbTest.update", test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    @Override
    public int deleteTest(Test test) {
        int result=0;
        try {
            getSqlSessionTemplate().delete("jxtbTest.delete", test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

}
