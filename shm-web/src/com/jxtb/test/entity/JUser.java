package com.jxtb.test.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-31
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */
public class JUser {

    private String uid;
    private String username;
    private String password;
    private String address;

    public String getUsername() {
        return username;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

