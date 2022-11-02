package org.example;

import io.javalin.Javalin;
import org.example.controller.BlogController;
import org.example.controller.UserController;
import org.example.repository.InMemoryBlogRepository;
import org.example.repository.InMemoryUserRepository;
import org.example.service.BlogService;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        var blogRepository = new InMemoryBlogRepository();
        var blogService = new BlogService(blogRepository);
        BlogController blogController = new BlogController(blogService);

        var userRepository = new InMemoryUserRepository();
        var userService = new UserService(userRepository);
        UserController userController = new UserController(userService);



        createBlogApp(blogController, userController).start(5000);


    }



    public static Javalin createBlogApp(BlogController blogController, UserController userController) {
        var app = Javalin.create()
                .get("/blogs", blogController::getAllBlogPosts)
                .put("/blog", blogController::saveBlogPost)
                .delete("/blog", blogController::deleteBlogPost)
                .get("/users", userController::getAllUsers)
                .put("/user", userController::saveUser);
        return app;

    }


}