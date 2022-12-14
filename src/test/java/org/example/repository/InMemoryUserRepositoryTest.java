package org.example.repository;


import org.example.data.User;
import org.example.exceptions.NoEmailException;
import org.example.exceptions.TooShortUsernameException;
import org.example.exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("userData")
    void test_get_users(List<User> users, int expected) {

        users.forEach(user -> userRepository.saveUser(user));

        Assertions.assertEquals(expected, userRepository.getAllUsers().size());
    }

    static Stream<Arguments> userData() {
        return Stream.of(
                Arguments.arguments(List.of(
                        new User("Kalle", "kallegmail", "123"),
                        new User("Albin", "albingmail", "123"),
                        new User("Stina", "stinagmail", "123")
                ),3
        ));
    }

    static Stream<Arguments> saveUser() {
        return Stream.of(
                Arguments.arguments(List.of(
                        new User(null, "", "123"),
                        new User("ellOr-varniini", "", "123"),
                        new User("Elin", "elingmail", "123"),
                        new User("nl", "arvidgmail", "123"),
                        new User("n", "ingvargmail", "123"),
                        new User("Kalle", "kallegmail", "123"),
                        new User("Kalle", "kallegmail", "123")
                ), 2)
        );
    }

}