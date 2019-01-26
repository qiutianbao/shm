package com.jxtb.test.dao;

import com.jxtb.test.entity.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-24
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
public interface SessionDao {
    public List<Test> findAllTest();

    public int addAllTest(Test test);

    public int deleteAllTest(Test test);

    public int updateAllTest(Test test);

    public Test findTestById(String id);

}
