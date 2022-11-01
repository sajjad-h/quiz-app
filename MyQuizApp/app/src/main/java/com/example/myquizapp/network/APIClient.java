package com.example.myquizapp.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static String BASE_URL = "http://quiz.servehttp.com/api/";
    public static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    //.readTimeout(45,TimeUnit.SECONDS)
                    //.writeTimeout(45,TimeUnit.SECONDS)
                    .build();

            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}