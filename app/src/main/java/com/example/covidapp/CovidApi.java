package com.example.covidapp;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Pais;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CovidApi {
    @GET
    Call<All> loadData(@Url String url);
}
