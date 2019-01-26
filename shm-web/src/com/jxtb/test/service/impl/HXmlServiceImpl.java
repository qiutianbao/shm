package com.jxtb.test.service.impl;

import com.jxtb.test.dao.HXmlDao;
import com.jxtb.test.entity.JUser;
import com.jxtb.test.service.HXmlService;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-4-1
 * Time: 下午6:03
 * To change this template use File | Settings | File Templates.
 */
public class HXmlServiceImpl implements HXmlService{

    private HXmlDao hXmlDao;

    public HXmlDao gethXmlDao() {
        return hXmlDao;
    }

    public void sethXmlDao(HXmlDao hXmlDao) {
        this.hXmlDao = hXmlDao;
    }

    @Override
    public int addJUserInfo(JUser user) {
        return hXmlDao.addJUserInfo(user);
    }
}
