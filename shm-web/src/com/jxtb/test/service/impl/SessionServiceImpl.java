package com.jxtb.test.service.impl;

import com.jxtb.test.dao.SessionDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.ISessionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-24
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
@Service("sessionService")
public class SessionServiceImpl implements ISessionService {
    @Resource(name = "sessionDao")
    private SessionDao sessionDao;
    @Override
    @Transactional(readOnly=true)
    public List<Test> findAllTest() {
        return sessionDao.findAllTest();
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public int addAllTest(Test test) {
        return sessionDao.addAllTest(test);
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public int deleteAllTest(Test test) {
        return sessionDao.deleteAllTest(test);
    }

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public int updateAllTest(Test test) {
        return sessionDao.updateAllTest(test);
    }

    @Override
    @Transactional(readOnly=true)
    public Test findTestById(String id) {
        return sessionDao.findTestById(id);
    }
}
