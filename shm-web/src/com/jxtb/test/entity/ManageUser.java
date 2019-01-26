package com.jxtb.test.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-31
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public class ManageUser {
    private String user_id;//用户id
    private String user_name;//用户名称
    private String user_password;//用户密码
    //一个用户可以有多个角色
    private Set<ManageRole> setRole = new HashSet<ManageRole>();

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Set<ManageRole> getSetRole() {
        return setRole;
    }

    public void setSetRole(Set<ManageRole> setRole) {
        this.setRole = setRole;
    }
}

