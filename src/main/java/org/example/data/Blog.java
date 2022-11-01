package org.example.data;

import lombok.Data;

@Data
public class Blog {

    String title;
    String content;
    static int idCounter = 0;
    int id;

    public Blog(String title, String content) {
        idCounter++;
        this.title = title;
        this.content = content;
        this.id = idCounter;

    }

}
