package com.jxtb.thread.run;

import com.core.exception.BdRuntimeException;
import com.jxtb.thread.RunThreadService;
import com.jxtb.thread.server.service.SyncTestService;
import com.util.ConfigurationHelper;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTestServiceImpl extends RunThreadService {

    private Logger logger = Logger.getLogger(ThreadTestServiceImpl.class);

    @Resource(name = "syncTestService")
    protected SyncTestService syncTestService;

    public void startRun() {
        logger.info("==============启动发送队列同步程序==============");
        alive = true;
        thread = new Thread(this, "ThreadTestServiceImpl");
        thread.setDaemon(false);
        thread.start();
    }

    /**
     *
     * 服务停止方法
     *
     * */
    public void stopRun() {
        alive = false;
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }

    @Override
    public void run() {
        try {
            logger.info("加载配置文件中.........");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (alive) {
            try {
                syncTestService.doSyncInfo();//启动同步
                //主线程配置时间
                int minus = ConfigurationHelper.getProperty("main.thread.sleep")==null?1:Integer.valueOf(ConfigurationHelper.getProperty("main.thread.sleep"));
                Thread.sleep(minus*1000*60);
            }catch (BdRuntimeException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
