package com.util.excelTools.module;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-4-7
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
public class People {
    /**
     * 编号
     */
    private int code;
    /**
     * 名称
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String addr;
    /**
     * 血型
     */
    private String blood;
    /**
     * 生日
     */
    private Date birthday;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getBlood() {
        return blood;
    }
    public void setBlood(String blood) {
        this.blood = blood;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}

