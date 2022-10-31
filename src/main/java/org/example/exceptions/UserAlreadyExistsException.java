package org.example.exceptions;

public class UserAlreadyExistsException extends Exception{
    private final Type type;

    public UserAlreadyExistsException(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        UserName,
        Email
    }
}
