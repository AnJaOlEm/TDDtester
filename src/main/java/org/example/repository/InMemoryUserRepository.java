package org.example.repository;


import org.example.data.User;
import org.example.exceptions.NoEmailException;
import org.example.exceptions.TooShortUsernameException;
import org.example.exceptions.UserAlreadyExistsException;

import java.util.List;

public class InMemoryUserRepository implements UserRepository{

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
