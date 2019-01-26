package com.jxtb.test.service;

import com.jxtb.test.entity.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午12:06
 * To change this template use File | Settings | File Templates.
 */
public interface IMyBatisService {

    public List<Test> getAllUser();

    public int addBook(Test test);

    public int deleteBook(Test test);

    public int updateBook(Test test);
}
