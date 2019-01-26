package com.jxtb.test.service.impl;

import com.jxtb.test.dao.HSQLQueryDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IHSQLQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("hsqlQueryService")
public class IHSQLQueryServiceImpl implements IHSQLQueryService {
    @Resource(name = "hsqlQueryDao")
    private HSQLQueryDao hsqlQueryDao;

    @Override
    public List<Test> findAllTest() {
        return hsqlQueryDao.findAllTest();
    }

}
