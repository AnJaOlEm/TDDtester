package org.example.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.example.service.BlogService;
import org.example.service.UserService;

public class BlogController {


    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    public void getAllBlogPosts(Context ctx) {
        var blogs = blogService.getAllBlogPosts();
        var json = gson.toJson(blogs);
        ctx.status(HttpStatus.OK);
        ctx.json(json);
    }

    public void saveBlogPost(Context context) {
    }

    public void deleteBlogPost(Context context) {
    }
}
