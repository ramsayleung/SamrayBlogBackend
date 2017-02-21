package com.samray.security.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 2/7/17
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final  long serialVersionUID=3705043083010304496L;
    public AuthMethodNotSupportedException(String message){
        super(message);
    }
}
