package com.ztom.library.exception;

/**
 * author:ztom
 * date:2018/10/25 18:11
 */
public class RepeatAppointException extends RuntimeException {
    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
