package com.zmk.exception;

import org.springframework.security.core.AuthenticationException;

public class MobilePhoneNotFoundException extends AuthenticationException {
    public MobilePhoneNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public MobilePhoneNotFoundException(String msg) {
        super(msg);
    }

}
