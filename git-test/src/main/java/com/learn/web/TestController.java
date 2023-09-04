package com.learn.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping ("/hello")
    public String hello() {
        return "hello world!";
    }
}