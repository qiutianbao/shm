package com.jxtb.thread;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 上午11:06
 * To change this template use File | Settings | File Templates.
 */
public abstract class RunThreadService implements Runnable {

    protected Thread thread;
    protected boolean alive = false;
    protected long sleepTime = 15000; // 睡眠时间，单位毫秒

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

    /***
     *
     * 是否正在运行
     *
     * */
    public boolean isAlive() {
        if (thread == null)
            return false;
        if (thread.isAlive())
            return true;
        return false;
    }

    /**
     * 对启动服务时的等待时间进行设置
     * 该等待主要为系统参数设置服务.
     *
     * */
    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

}
