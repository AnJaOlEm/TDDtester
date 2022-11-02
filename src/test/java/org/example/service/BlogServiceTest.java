package org.example.service;

import org.example.data.Blog;
import org.example.repository.BlogRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BlogServiceTest {

    BlogRepository blogRepository;
    BlogService blogService;

    @BeforeEach
    void setup(){
        blogRepository = Mockito.mock(BlogRepository.class);
        blogService = new BlogService(blogRepository);
    }

    //save blog
    @Test
    @DisplayName("Save blog post service test")
    void test_save_blog_post(){
        var title = "Hello monday";
        var content = " Idag we have danced hela dagen";

        var blog = blogService.saveBlogPost(title, content);
        Mockito.verify(blogRepository).saveBlogPost(Mockito.any(Blog.class));
        Assertions.assertNotNull(blog);
    }

    //delete blog
    @Test
    @DisplayName("Delete blog post service test")
    void test_delete_blog_post() {

    }

}