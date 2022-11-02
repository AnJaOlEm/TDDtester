package org.example.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.testtools.JavalinTest;
import org.example.Main;
import org.example.data.User;
import org.example.repository.InMemoryUserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class UserControllerTest {
    
    @Test
    @DisplayName("Test get all users empty list")
    void test_get_all_users(){

        var repository = new InMemoryUserRepository();
        var service = new  UserService(repository);
        var controller = new UserController(service);
        var app = Main.createApp(controller);

        JavalinTest.test(app, (server , client) -> {
            client.get("/users");
            var code = client.get("/users").code();
            var body = client.get("/users").body().string();

            Assertions.assertEquals(200, code);
            Assertions.assertEquals("[]", body);
        });



}

}