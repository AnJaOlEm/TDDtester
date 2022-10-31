package org.example.data;

import lombok.Data;

@Data
public class Blog {

    String title;
    String content;

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
