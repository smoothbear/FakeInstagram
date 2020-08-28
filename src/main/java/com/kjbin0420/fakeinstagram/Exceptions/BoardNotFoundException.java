package com.kjbin0420.fakeinstagram.Exceptions;

public class BoardNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2916857278372941594L;

    public BoardNotFoundException() {
        super("Board is Not Found!!");
    }
}
