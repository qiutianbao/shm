package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.HQueryDao;
import com.jxtb.test.entity.Test;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Repository("hQueryDao")
public class HQueryDaoImpl extends BaseDao<Test> implements HQueryDao{

    public List<Test> findAllTest() {
        String hql="from Test";
        Query query=getSession().createQuery(hql);
       /* Test test=new Test();
        Iterator<Test> iterator=getSession().createQuery(hql).iterate();
        while (iterator.hasNext()){
            test=iterator.next();
            System.out.println(test.getUserName()+"\t"+test.getUserPsw());
        }*/
        return query.list();
    }

}
