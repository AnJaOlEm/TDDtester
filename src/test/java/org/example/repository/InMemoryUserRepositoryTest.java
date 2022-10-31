package org.example.repository;

import org.example.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class InMemoryUserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository = new InMemoryUserRepository();
    }

    @Test
    @DisplayName("Get users")
    void get_users_tests() {
        List<User> users = userRepository.getAllUsers();

        int expected = 0;

        Assertions.assertEquals(expected, users);

    }

}