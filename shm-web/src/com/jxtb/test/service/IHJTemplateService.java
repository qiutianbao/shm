package com.jxtb.test.service;

import com.jxtb.test.entity.Test;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
public interface IHJTemplateService {
    public List<Map<String, Object>> selectJdbcTestList(String userId);

    public int addJdbcTest(Test test);

    public int deleteJdbcTest(Test test);

    public int updateJdbcTest(Test test);

    public List<Test> findAllTest();

    public String searchUserNameById(String id);

    public Test searchJdbcTestById(String id);


    public List<Test> selectHibernateTestList();

    public int addHibernateTest(Test test);

    public int updateHibernateTest(Test test);

    public int deleteHibernateTestById(Test test);

    public Test searchHibernateTestById(String id);

}
