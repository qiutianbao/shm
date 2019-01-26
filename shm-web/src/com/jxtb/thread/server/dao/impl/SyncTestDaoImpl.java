package com.jxtb.thread.server.dao.impl;

import com.core.exception.BdRuntimeException;
import com.jxtb.thread.server.dao.SyncTestDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 下午12:16
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Repository("syncTestDao")
public class SyncTestDaoImpl implements SyncTestDao {
    @Override
    public void doSyncInfo() throws BdRuntimeException {
        System.out.println("aaaaaaaaaaaa");
    }
}
