package org.example;

import io.javalin.Javalin;
import org.example.controller.BlogController;
import org.example.controller.UserController;
import org.example.repository.InMemoryUserRepository;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}