package com.kjbin0420.fakeinstagram.Exceptions;

public class InvalidTokenException extends RuntimeException {
    private static final long serialVersionUID = 7748317098314959297L;

    public InvalidTokenException() {
        super("Token is not refresh token!!");
    }
}
