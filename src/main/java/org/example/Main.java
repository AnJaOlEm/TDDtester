package org.example;

import io.javalin.Javalin;
import org.example.controller.BlogController;
import org.example.controller.UserController;
import org.example.repository.InMemoryUserRepository;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
//        var blogRepository = new InMemoryUserRepository();
//        var blogService = new UserService(blogRepository);
//        BlogController blogController = new BlogController(blogService);

        var userRepository = new InMemoryUserRepository();
        var userService = new UserService(userRepository);
        UserController userController = new UserController(userService);



        createUserApp(userController).start(5000);


    }

    public static Javalin createUserApp(UserController userController) {
        var app1 = Javalin.create()
                .get("/users", userController::getAllUsers)
                .put("/user", userController::saveUser);

        return app1;
    }

//    public static Javalin createBlogApp(BlogController blogController) {
//        var app2 = Javalin.create()
//                .get("/blogs", blogController::get)
//    }


}