package com.example.myquizapp.network.response;

import com.example.myquizapp.entities.Question;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class QuestionResponseModel {

    @SerializedName(value = "questionText")
    private String questionText;

    @SerializedName(value = "option1")
    private String option1;

    @SerializedName(value = "option2")
    private String option2;

    @SerializedName(value = "option3")
    private String option3;

    @SerializedName(value = "option4")
    private String option4;

    @SerializedName(value = "correctOption")
    private String correctOption;

    public QuestionResponseModel(String questionText, String option1, String option2, String option3, String option4, String correctOption) {
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public Question toQuestionModel() {
        System.out.println(getCorrectOption());
        Question question = new Question(questionText, option1, option2, option3, option4, Integer.valueOf(correctOption));
        return question;
    }
}
