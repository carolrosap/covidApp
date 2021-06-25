package com.example.covidapp;

import com.example.covidapp.model.All;
import com.example.covidapp.model.CountryAll;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface Service {

    @GET
    Call<All> loadAll(@Url String url);

    @GET
    Call<Object> loadCountryAll(@Url String url);


}
