package com.kevin.HRSystem.exception;

public class HrException extends RuntimeException {
    public HrException() {}

    public HrException(String msg) {
        super(msg);
    }
}
