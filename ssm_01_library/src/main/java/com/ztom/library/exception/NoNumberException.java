package com.ztom.library.exception;

/**
 * author:ztom
 * date:2018/10/25 18:10
 */
public class NoNumberException extends RuntimeException {
    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
