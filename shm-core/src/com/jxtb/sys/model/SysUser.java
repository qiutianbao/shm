package com.jxtb.sys.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-18
 * Time: 下午12:16
 * To change this template use File | Settings | File Templates.
 */
public class SysUser {
    private String id;

    private String userName;

    private String userPsw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }
}
