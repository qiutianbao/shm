package com.jxtb.test.support;

import com.jxtb.test.entity.Test;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午2:38
 *  extends HibernateDaoSupport
 */
@SuppressWarnings("ALL")
public class HDSupport extends HibernateDaoSupport {

    /**
     * 保存新问题
     *
     * @return
     */
    public int saveTest(Test test) {
        return Integer.parseInt(super.getHibernateTemplate().save(test).toString());
    }

    public List<Test> findAll(){
        List<Test> test = (List<Test>) getHibernateTemplate().find("from Test");
        return test;
    }

    /**
     * 查询制定问题的所有答案信息
     *
     * @return
     */
    public Test queryTestById(String id) {
        return super.getHibernateTemplate().get(Test.class, id);
      /*  List<Test> entities= (List<Test>) super.getHibernateTemplate().find("from Customer where id="+id);
        if(entities.size()>0){
            Test entity=entities.get(0);
            return entity;
        }
        return null;*/
    }

    /**
     * 修改制定问题的回答次数和最后修改时间
     *
     * @return
     */
    public int updateTest(Test test) {
        int result=0;
        try {
            super.getHibernateTemplate().update(test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }
    /**
     * 删除问题
     *
     * @return
     */
    public int deleteTest(Test test) {
        int result=0;
        try {
            super.getHibernateTemplate().delete(test);
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

}

