package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myquizapp.entities.Question;
import com.example.myquizapp.libraries.QuestionsLibrary;
import com.example.myquizapp.network.APIClient;
import com.example.myquizapp.network.response.QuestionResponseModel;
import com.example.myquizapp.network.service.QuestionService;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView questionText, scoreValue;
    RadioButton option1, option2, option3, option4, answeredOption;
    RadioGroup radioGroup;
    Button submitButton;
    Integer currentScore = 0;
    QuestionsLibrary questionsLibrary = new QuestionsLibrary();
    Question question;
    QuestionService questionService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = (TextView) findViewById(R.id.question);
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option4 = (RadioButton) findViewById(R.id.option4);
        radioGroup = (RadioGroup) findViewById(R.id.options);
        submitButton = (Button) findViewById(R.id.submitButton);
        scoreValue = (TextView) findViewById(R.id.scoreValue);

        questionService = APIClient.getInstance().create(QuestionService.class);

        writeQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = radioGroup.getCheckedRadioButtonId();
                answeredOption = (RadioButton) findViewById(selectedOptionId);
                if(selectedOptionId == -1){
                    Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Integer selectedOption = Integer.parseInt((String) answeredOption.getHint());
                    System.out.println(selectedOption);
                    System.out.println(question.getCorrectOption());
                    if (selectedOption == question.getCorrectOption()) {
                        Toast.makeText(MainActivity.this, "Chill! You choose correct option.", Toast.LENGTH_SHORT).show();
                        currentScore++;
                        scoreValue.setText(currentScore.toString());
                        writeQuestion();
                    } else {
                        Toast.makeText(MainActivity.this, "wrong option: " + answeredOption.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void writeQuestion() {
        System.out.println("hi sajjad!");
        questionService.getQuestion().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<QuestionResponseModel> call, Response<QuestionResponseModel> response) {
                System.out.println(response);
                if (response.code() == 200) {
                    QuestionResponseModel questionResponseModel = response.body();
                    question = questionResponseModel.toQuestionModel();
                    questionText.setText(question.getQuestionText());
                    option1.setText(question.getOption1());
                    option2.setText(question.getOption2());
                    option3.setText(question.getOption3());
                    option4.setText(question.getOption4());
                } else {
                    System.out.println(response.code() + "i failed here");
                }
            }

            @Override
            public void onFailure(Call<QuestionResponseModel> call, Throwable t) {
                System.out.println("it was failed!");
            }
        });
    }
}