package com.example.covidapp;

import android.util.Log;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Country;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidApiService {
    private Retrofit retrofit;
    private All all;

    private Country country;
    private Call<All> call;

    public CovidApiService(){
        super();
    }
    public All getAll() {
        return all;
    }

    public Country getCountry() {
        return country;
    }

    public Call<All> getCall() {
        return call;
    }


    public void newRequest(String params) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi jsonApi = retrofit.create(CovidApi.class);
        call = jsonApi.loadData("https://covid-api.mmediagroup.fr/v1/cases?" + params);
    }

}
