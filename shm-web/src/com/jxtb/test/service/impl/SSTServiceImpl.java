package com.jxtb.test.service.impl;

import com.jxtb.test.dao.SSTDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.ISSTService;
import com.jxtb.test.support.SSDSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
@Service("isstService")
public class SSTServiceImpl implements ISSTService {
    @Resource(name = "sstDao")
    private SSTDao sstDao;

    @Resource(name = "ssdSupport")
    private SSDSupport ssdSupport;

    @Override
    public List<Test> findAllTest() {
        return sstDao.findAllTest();
    }

    @Override
    public int savTest(Test test) {
        return sstDao.savTest(test);
    }

    @Override
    public Test queryTestById(HashMap<String, Object> map) {
        return sstDao.queryTestById(map);
    }

    @Override
    public int findTotalCount() {
        return sstDao.findTotalCount();
    }

    @Override
    public int updateTest(Test test) {
        return sstDao.updateTest(test);
    }

    @Override
    public int deleteTest(Test test) {
        return sstDao.deleteTest(test);
    }

    public List<Map<String, Object>> showAllTest(HashMap<String, Object> map) {
        return ssdSupport.showAllTest(map);
    }

    public int searchTestTotal(HashMap<String, Object> map){
        return ssdSupport.searchTestTotal(map);
    }

    public int insertTestInfo(Test test) {
        return ssdSupport.insertTestInfo(test);
    }

    public int deleteTestInfo(Test test) {
        return  ssdSupport.deleteTestInfo(test);
    }

    public int updateTestInfo(Test test) {
       return ssdSupport.updateTestInfo(test);
    }

}
