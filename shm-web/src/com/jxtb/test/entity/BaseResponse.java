package com.jxtb.test.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-8-8
 * Time: 上午7:44
 * To change this template use File | Settings | File Templates.
 */
public class BaseResponse {
    private String msg;

    private String code;

    private String signnature;

    private Object param;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSignnature() {
        return signnature;
    }

    public void setSignnature(String signnature) {
        this.signnature = signnature;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
