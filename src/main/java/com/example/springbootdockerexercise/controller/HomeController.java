package com.example.springbootdockerexercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {

    @ResponseBody
    @GetMapping("/")
    public String home() {
        return "Hello";
    }
}
