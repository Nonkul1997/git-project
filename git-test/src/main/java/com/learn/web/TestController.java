package com.learn.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author xiaochuan
 * @date 2023/10/6 16:36
 * @description TestController
 */
@RestController
public class TestController {

    @GetMapping ("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello git, test branch!";
    }
}
