package com.finger.common.exception;

/**
 * Created by ZH on 2016/7/19.
 */
public class DataAccessException extends Exception{

    static final long serialVersionUID = 1L;

    public DataAccessException(){
        super();
    }

    public DataAccessException(String message,Throwable cause){
        super(message,cause);
    }

    public DataAccessException(String message){
        super(message);
    }

    public DataAccessException(Throwable cause){
        super(cause);
    }
}
