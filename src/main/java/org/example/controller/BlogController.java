package org.example.controller;

import io.javalin.http.Context;
import org.example.service.BlogService;
import org.example.service.UserService;

public class BlogController {


    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    public void getAllBlogPosts(Context context) {
    }

    public void saveBlogPost(Context context) {
    }

    public void deleteBlogPost(Context context) {
    }
}
