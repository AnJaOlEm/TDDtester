package org.example.service;


import org.example.data.User;
import org.example.exceptions.NoEmailException;
import org.example.exceptions.TooShortUsernameException;
import org.example.exceptions.UserAlreadyExistsException;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("Create user stores in userRepository")
    void create_stores_user () throws NoEmailException, TooShortUsernameException, UserAlreadyExistsException {
        var userName = "Kalle";
        var email = "svenatgmailpunktcom";
        var password = "123";

        var user = Assertions.assertDoesNotThrow(() -> userService.saveUser(User.class));

        Mockito.verify(userRepository).saveUser(Mockito.any(User.class));
        Assertions.assertNotNull(user);
    }

}