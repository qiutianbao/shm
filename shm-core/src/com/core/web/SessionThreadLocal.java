package com.core.web;

import com.jxtb.sys.model.SysUser;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-19
 * Time: 上午10:56
 * 解决多线程程序的并发
 */
public class SessionThreadLocal {
    private static ThreadLocal<SysUser> ADMINUSERTHREADLOCAL = new ThreadLocal<SysUser>();

    //返回当前线程所对应的线程局部变量。
    public static SysUser getThreadSysUser() {
        return ADMINUSERTHREADLOCAL.get();
    }

    //设置当前线程的线程局部变量的值。
    public static void setThreadSysUser(SysUser sysUser) {
        ADMINUSERTHREADLOCAL.set(sysUser);
    }

    //将当前线程局部变量的值删除，目的是为了减少内存的占用
    public static void remove(){
        ADMINUSERTHREADLOCAL.remove();
    }

    //返回该线程局部变量的初始值
    public static SysUser initialValue(){
        return null;
    }

}
