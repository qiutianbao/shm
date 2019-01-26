package com.jxtb.test.dao.impl;

import com.core.dao.BaseDao;
import com.jxtb.test.dao.HCriteriaDao;
import com.jxtb.test.entity.Test;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Repository("hCriteriaDao")
public class HCriteriaDaoImpl extends BaseDao<Test>  implements HCriteriaDao {

    public List<Test> findAllTest() {
        Criteria criteria=getSession().createCriteria(Test.class);
        return criteria.list();
    }

}
