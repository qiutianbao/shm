package com.jxtb.test.service.impl;

import com.jxtb.test.dao.HJTemplateDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IHJTemplateService;
import com.jxtb.test.support.HDSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-20
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("hjTemplateService")
public class IHJTemplateServiceImpl implements IHJTemplateService {

    @Resource(name = "hjTemplateDao")
    private HJTemplateDao hjTemplateDao;

    @Override
    public List<Map<String, Object>> selectJdbcTestList(String userId) {
        return hjTemplateDao.selectJdbcTestList(userId);
    }

    @Override
    public int addJdbcTest(Test test) {
        return hjTemplateDao.addJdbcTest(test);
    }

    @Override
    public int deleteJdbcTest(Test test) {
        return hjTemplateDao.deleteJdbcTest(test);
    }

    @Override
    public int updateJdbcTest(Test test) {
        return hjTemplateDao.updateJdbcTest(test);
    }

    @Override
    public List<Test> findAllTest() {
        return hjTemplateDao.findAllTest();
    }

    @Override
    public String searchUserNameById(String id) {
        return hjTemplateDao.searchUserNameById(id);
    }

    @Override
    public Test searchJdbcTestById(String id) {
        return hjTemplateDao.searchJdbcTestById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Test> selectHibernateTestList() {
        return hjTemplateDao.selectHibernateTestList();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int addHibernateTest(Test test) {
        return hjTemplateDao.addHibernateTest(test);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateHibernateTest(Test test) {
        return hjTemplateDao.updateHibernateTest(test);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int deleteHibernateTestById(Test test) {
        return hjTemplateDao.deleteHibernateTestById(test);
    }

    @Override
    @Transactional(readOnly = true)
    public Test searchHibernateTestById(String id) {
        return hjTemplateDao.searchHibernateTestById(id);
    }

}
