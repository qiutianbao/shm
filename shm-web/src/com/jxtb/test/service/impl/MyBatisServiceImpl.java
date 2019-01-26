package com.jxtb.test.service.impl;

import com.jxtb.test.dao.MyBatisDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IMyBatisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午12:06
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("myBatisService")
public class MyBatisServiceImpl implements IMyBatisService {

    @Resource(name="myBatisDao")
    private MyBatisDao myBatisDao;

    @Transactional(readOnly=true)
    public List<Test> getAllUser() {
        return myBatisDao.getAllUser();
    }
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public int addBook(Test test) {
        return myBatisDao.addTestInfo(test);
    }
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public int deleteBook(Test test) {
        return myBatisDao.deleteTestInfo(test);
    }
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public int updateBook(Test test) {
        return myBatisDao.updateTestInfo(test);
    }

}
