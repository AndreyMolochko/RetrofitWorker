package com.example.retrofitworker;

import android.app.Application;

import com.example.retrofitworker.networking.JsonPlaceHolderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private final static String URL = "https://jsonplaceholder.typicode.com/";
    static Retrofit retrofit = getRetrofit(URL);
    public static JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    private static Retrofit getRetrofit(String url){
        return new Retrofit.Builder().baseUrl(url)
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .build();
    }
}
