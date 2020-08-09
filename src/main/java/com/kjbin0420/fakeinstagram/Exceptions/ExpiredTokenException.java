package com.kjbin0420.fakeinstagram.Exceptions;

public class ExpiredTokenException extends RuntimeException {
    private static final long serialVersionUID = -6149067077921729340L;

    public ExpiredTokenException() {
        super("Expired Token!!");
    }
}
