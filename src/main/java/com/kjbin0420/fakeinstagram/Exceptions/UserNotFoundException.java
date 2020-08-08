package com.kjbin0420.fakeinstagram.Exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3205057992054017970L;

    public UserNotFoundException() {
        super("User is Not Found!!");
    }
}
