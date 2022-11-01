package org.example.repository;

import org.example.data.Blog;
import org.example.data.User;
import org.example.exceptions.NoEmailException;
import org.example.exceptions.TooShortUsernameException;
import org.example.exceptions.UserAlreadyExistsException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryBlogRepository implements BlogRepository{

    private final Map<String, Blog> data = new HashMap<>();




    @Override
    public void saveBlogPost(Blog blog) {
        data.put(blog.getId(), blog);

    }



    @Override
    public Collection<Blog> getAllBlogPosts() {
        return data.values();
    }


}
