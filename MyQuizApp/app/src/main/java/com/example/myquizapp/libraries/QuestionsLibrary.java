package com.example.myquizapp.libraries;

import com.example.myquizapp.entities.Question;

import java.util.ArrayList;

public class QuestionsLibrary {
    private ArrayList<Question> questions;

    public QuestionsLibrary() {
        questions = new ArrayList<Question>();
        questions.add(new Question("Who are you?", "Robot", "Human", "Bird", "Animal", 2));
        questions.add(new Question("Which of the following are two main parts of CSS rule?", "Selector, declaration", "Select, declaration", "Selector, declare", "Selection, declaration", 1));
        questions.add(new Question("Which of the following is the syntax of CSS?", "Select {property : value}", "Selector {value : property}", "Selector {property : value}", "Selection {property : value}", 3));
        questions.add(new Question("Which of the following has developed JavaScript?", "Yahoo", "Google", "Wikipedia", "Netscape", 4));
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
