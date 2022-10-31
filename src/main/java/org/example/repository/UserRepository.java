package org.example.repository;

import org.example.data.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
}
