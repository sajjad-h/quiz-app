package com.example.myquizapp.repository;

import android.app.Application;

import com.example.myquizapp.entities.Question;
import com.example.myquizapp.network.APIClient;
import com.example.myquizapp.network.response.QuestionResponseModel;
import com.example.myquizapp.network.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionRepository {
    private QuestionService questionService;

    public QuestionRepository(Application application) {
        questionService = APIClient.getInstance().create(QuestionService.class);
    }

    public Question getQuestion() {
        final Question[] question = new Question[1];
        questionService.getQuestion().enqueue(new Callback<QuestionResponseModel>() {
            @Override
            public void onResponse(Call<QuestionResponseModel> call, Response<QuestionResponseModel> response) {
                System.out.println(response);
                if (response.code() == 200) {
                    QuestionResponseModel questionResponseModel = response.body();
                    question[0] = questionResponseModel.toQuestionModel();
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<QuestionResponseModel> call, Throwable t) {

            }
        });
        return question[0];
    }

}
