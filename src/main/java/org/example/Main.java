package org.example;

import io.javalin.Javalin;
import org.example.controller.BlogController;
import org.example.controller.UserController;
import org.example.repository.InMemoryUserRepository;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        var blogRepository = new InMemoryUserRepository();
        var blogService = new UserService(blogRepository);
        BlogController blogController = new BlogController(blogService);

        var userRepository = new InMemoryUserRepository();
        var userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        Javalin app = Javalin.create().start(5555);

        app.get("/users", userController.getAllUsers());


    }


}