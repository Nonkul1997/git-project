package com.learn.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping ("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello git, test branch!";
    }
}
