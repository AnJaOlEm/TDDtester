package org.example.controller;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.example.Main;
import org.example.repository.InMemoryUserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlogControllerTest {

    @Test
    @DisplayName("Test that an empty list returns")
    void get_blogs_test() {
        var blogRepository = new InMemoryUserRepository();
        var blogService = new UserService(blogRepository);
        var blogController = new BlogController(blogService);
        var app = Main.createAppBlog(blogController);

        JavalinTest.test(app, (server, client) -> {
            var code = client.get("/blogs").code();
            var body = client.get("/blogs").body().string();
        });
    }

}