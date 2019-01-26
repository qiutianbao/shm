package com.jxtb.test.dao;

import com.jxtb.test.entity.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
public interface HQueryDao {
    public List<Test> findAllTest();
}
