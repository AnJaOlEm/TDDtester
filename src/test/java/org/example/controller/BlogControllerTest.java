package org.example.controller;

import com.google.gson.Gson;
import io.javalin.testtools.JavalinTest;
import org.example.Main;
import org.example.data.Blog;
import org.example.repository.InMemoryBlogRepository;
import org.example.repository.InMemoryUserRepository;
import org.example.service.BlogService;
import org.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class BlogControllerTest {

    @Test
    @DisplayName("Test that an empty list returns")
    void get_blogs_test() {
        var blogRepository = new InMemoryBlogRepository();
        var blogService = new BlogService(blogRepository);
        var blogController = new BlogController(blogService);
        var app = Main.createBlogApp(blogController, userController);

        JavalinTest.test(app, (server, client) -> {
            var code = client.get("/blogs").code();
            var body = client.get("/blogs").body().string();

            Assertions.assertEquals(200, code);
            Assertions.assertEquals("[]", body);
        });
    }

}