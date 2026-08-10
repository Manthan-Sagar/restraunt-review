package com.manthan.restraunt.Exceptions;


public class BaseExceptions  extends RuntimeException{

    public BaseExceptions() {
    }

    public BaseExceptions(String message) {
        super(message);
    }

    public BaseExceptions(Throwable cause) {
        super(cause);
    }

    public BaseExceptions(String message, Throwable cause) {
        super(message, cause);
    }
    
}
