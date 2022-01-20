package com.hello.quiz.controllers.api;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/question")
public class QuestionController {
    @GetMapping("")
    public HashMap<String, String> getQuestions() {
        HashMap<String, String> values = new HashMap<>();
        values.put("questionText", "What is your name?");
        values.put("option1", "Sajjad");
        values.put("option2", "Hossain");
        values.put("option3", "Nazmul");
        values.put("option4", "Rifat");
        values.put("correctOption", "1");
        return values;
    }

}
