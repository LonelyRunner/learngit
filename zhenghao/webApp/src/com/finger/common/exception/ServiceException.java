package com.finger.common.exception;

/**
 * Created by ZH on 2016/7/19.
 */
public class ServiceException extends Exception{

    static final long serialVersionUID = 1L;

    private String message;

    public ServiceException(String message,Exception e){
        super(message,e);
        this.message = message;
    }

    public ServiceException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
