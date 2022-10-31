package org.example.repository;

import org.example.data.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBlogRepositoryTest {

    BlogRepository blogRepository;

    @Test
    @DisplayName("Get all blogposts")
    void test_create_blogpost(){

        blogRepository.saveBlogPost(new Blog("Måndag", "Baka kaka hela dagen"));

        Assertions.assertEquals(1, blogRepository.getAllBlogPosts().size());
    }
}