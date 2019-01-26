package com.jxtb.thread.server.service;

import com.core.exception.BdRuntimeException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 下午12:12
 * To change this template use File | Settings | File Templates.
 */
public interface SyncTestService {
    void doSyncInfo() throws BdRuntimeException;
}
