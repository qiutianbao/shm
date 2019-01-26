package com.jxtb.thread.server.service.impl;

import com.core.exception.BdRuntimeException;
import com.jxtb.thread.server.dao.SyncTestDao;
import com.jxtb.thread.server.service.SyncTestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 下午12:14
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service("syncTestService")
public class SyncTestServiceImpl implements SyncTestService {

    @Resource(name = "syncTestDao")
    private SyncTestDao syncTestDao;

    @Override
    public void doSyncInfo() throws BdRuntimeException {
        syncTestDao.doSyncInfo();
    }
}
