package com.example.soumyajitdas.reactdemo.Retro;

import com.example.soumyajitdas.reactdemo.ListModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiClient {

    @POST("/prod/charity-get-list")
    Observable<ListModel> getList(@Body PostBody user);
}



