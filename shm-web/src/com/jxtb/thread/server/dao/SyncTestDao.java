package com.jxtb.thread.server.dao;

import com.core.exception.BdRuntimeException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 下午12:16
 * To change this template use File | Settings | File Templates.
 */
public interface SyncTestDao {
    void doSyncInfo() throws BdRuntimeException;
}
