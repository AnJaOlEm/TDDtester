package org.example.controller;

import com.google.gson.Gson;
import io.javalin.testtools.JavalinTest;
import org.example.Main;
import org.example.data.User;
import org.example.repository.InMemoryUserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.*;

import java.util.HashMap;


class UserControllerTest {
    
    @Test
    @DisplayName("Test get all users empty list")
    void test_get_all_users(){

        var repository = new InMemoryUserRepository();
        var service = new  UserService(repository);
        var userController = new UserController(service);
        var app = Main.createBlogApp(blogController, userController);

        JavalinTest.test(app, (server , client) -> {
            client.get("/users");
            var code = client.get("/users").code();
            var body = client.get("/users").body().string();

            Assertions.assertEquals(200, code);
            Assertions.assertEquals("[]", body);
        });
    }

    @Test
    @DisplayName("Test save user")
    void test_save_user() {
        var blogRepository = new InMemoryBlogRepository();
        var blogService = new BlogService(blogRepository);
        var blogController = new BlogController(blogService);

        var repository = new InMemoryUserRepository();
        var service = new  UserService(repository);
        var userController = new UserController(service);
        var app = Main.createBlogApp(blogController, userController);

        JavalinTest.test(app, (server, client) -> {
            var map = new HashMap<>();
            map.put("userName", "Kalle");
            map.put("email", "k@gma.com");
            map.put("password", "123");

            var gson = new Gson();
            var user = new User("Kalle", "k@gma.com", "123");
            var output = gson.toJson(user);

            var res = client.put("/user", map);
            var code = res.code();
            var body = res.body();

            Assertions.assertEquals(200, code);
            Assertions.assertEquals(output, body.string());
        });

        app.close();
    }



}

