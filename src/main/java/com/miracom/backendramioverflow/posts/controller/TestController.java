package com.miracom.backendramioverflow.posts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "HELLO";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "HELLO2";
    }

    @GetMapping("/hello3")
    public String hello3() {
        return "HELLO3";
    }
}
