package com.ztom.library.exception;

/**
 * author:ztom
 * date:2018/10/25 18:12
 */
public class AppointException extends RuntimeException {
    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
