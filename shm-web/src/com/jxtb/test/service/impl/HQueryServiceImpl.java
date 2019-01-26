package com.jxtb.test.service.impl;

import com.jxtb.test.dao.HQueryDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IHQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("hQueryService")
public class HQueryServiceImpl implements IHQueryService{
    @Resource(name = "hQueryDao")
    private HQueryDao hQueryDao;

    @Override
    public List<Test> findAllTest() {
        return hQueryDao.findAllTest();
    }
}
