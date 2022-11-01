package com.example.myquizapp.network.service;

import com.example.myquizapp.network.response.QuestionResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface QuestionService {
    @GET("question")
    @Headers({"Content-Type: application/json"})
    Call<QuestionResponseModel> getQuestion();
}
