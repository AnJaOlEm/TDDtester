package org.example.repository;

import org.example.data.User;
import org.example.exceptions.NoEmailException;
import org.example.exceptions.TooShortUsernameException;
import org.example.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
}
