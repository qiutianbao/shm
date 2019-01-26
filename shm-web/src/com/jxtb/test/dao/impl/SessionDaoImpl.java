package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.SessionDao;
import com.jxtb.test.entity.Test;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-24
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Repository("sessionDao")
public class SessionDaoImpl extends BaseDao<Test> implements SessionDao{
    public List<Test> findAllTest() {
        String hql="from Test";
        Query query=getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public int addAllTest(Test test) {
        int result=0;
        try {
            getSession().save(test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    @Override
    public int deleteAllTest(Test test) {
        int result=0;
        try {
            getSession().delete(test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    @Override
    public int updateAllTest(Test test) {
        int result=0;
        try {
            getSession().update(test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    @Override
    public Test findTestById(String id) {
        String hql="from Test where id=?";
        Query query=getSession().createQuery(hql);
        query.setString(0,id);
        return query.list() == null || query.list().size() <= 0 ? null : (Test) query.list().get(0);
    }
}
