package com.jxtb.test.dao;

import com.jxtb.test.entity.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午1:49
 * To change this template use File | Settings | File Templates.
 */
public interface MyBatisDao {
    public List<Test> getAllUser();

    public int addTestInfo(Test test);

    public int deleteTestInfo(Test test);

    public int updateTestInfo(Test test);
}
