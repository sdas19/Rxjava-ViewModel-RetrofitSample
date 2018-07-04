package com.example.soumyajitdas.reactdemo.Retro;

import com.example.soumyajitdas.reactdemo.Retro.ApiClient;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static String BASE_URL="https://lz5xe7ubii.execute-api.ap-south-1.amazonaws.com/prod/";


    private static Retrofit getRetrofitInstance()
    {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static ApiClient getApiService()
    {
        return getRetrofitInstance().create(ApiClient.class);
    }
}
