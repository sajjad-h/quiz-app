package com.hello.quiz.controllers.api;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HomeController {
    @GetMapping("")
    public HashMap<String, String> home() {
        HashMap<String, String> res = new HashMap<>();
        res.put("hello", "Welcome to Quiz API Server!");
        return res;
    }
}