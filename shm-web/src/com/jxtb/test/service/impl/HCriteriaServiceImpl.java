package com.jxtb.test.service.impl;

import com.jxtb.test.dao.HCriteriaDao;
import com.jxtb.test.dao.HQueryDao;
import com.jxtb.test.entity.Test;
import com.jxtb.test.service.IHCriteriaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-27
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("hCriteriaService")
public class HCriteriaServiceImpl implements IHCriteriaService {
    @Resource(name = "hCriteriaDao")
    private HCriteriaDao hCriteriaDao;
    @Override
    public List<Test> findAllTest() {
        return hCriteriaDao.findAllTest();
    }
}
