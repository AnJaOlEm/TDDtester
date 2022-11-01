package org.example.repository;

import org.example.data.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBlogRepositoryTest {

    BlogRepository blogRepository;

    @BeforeEach
    void setup() {
        blogRepository = new InMemoryBlogRepository();
    }

    @Test
    @DisplayName("Get all blogposts")
    void test_create_blogpost(){

        blogRepository.saveBlogPost(new Blog("Måndag", "Baka kaka hela dagen"));

        Assertions.assertEquals(1, blogRepository.getAllBlogPosts().size());
    }

    @Test
    @DisplayName("Delete blog")
    void test_delete_blogpost() {

        blogRepository.saveBlogPost(new Blog("Måndag", "Baka kaka hela dagen"));
        blogRepository.saveBlogPost(new Blog("Tisdag", "Baka kaka hela dagen"));

        blogRepository.deleteBlogPost();

        Assertions.assertEquals(1, blogRepository.getAllBlogPosts().size());
    }
}