package com.kjbin0420.fakeinstagram.Exceptions;

public class FileStorageException extends RuntimeException{
    private static final long serialVersionUID = 6712417769526744426L;

    public FileStorageException(String fileName) {
        super("Could not store file!" + fileName);
    }
    public FileStorageException() {
        super("Could not save file!");
    }
}
