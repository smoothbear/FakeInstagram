package com.kjbin0420.fakeinstagram.Exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
    private static final long serialVersionUID = -4257509605753621077L;

    public UserAlreadyRegisteredException() {
        super("User Already Registered!!!");
    }
}
