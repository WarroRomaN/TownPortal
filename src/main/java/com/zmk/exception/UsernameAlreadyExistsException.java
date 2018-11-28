package com.zmk.exception;

public class UsernameAlreadyExistsException extends Throwable {
    public UsernameAlreadyExistsException(String s) {
        super(s);
    }
}
