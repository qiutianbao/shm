package com.core.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 上午11:18
 * To change this template use File | Settings | File Templates.
 */
public class BdRuntimeException extends Exception {

    private static final long serialVersionUID = 1L;

    public BdRuntimeException(){
        super();
    }

    public BdRuntimeException(String message){
        super(message);
    }

    public BdRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public BdRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}