package com.manthan.restraunt.Exceptions;

public class StorageException extends BaseExceptions{

    public StorageException() {
    }

    public StorageException(String message) {
        super(message);
    }

    public StorageException(Throwable cause) {
        super(cause);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
