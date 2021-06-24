package com.example.covidapp;

import android.util.Log;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Country;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidApiService {
    private  Retrofit retrofit;
    private All all;
    private Boolean failureFlag;
    private Country country;

    public CovidApiService(){
        super();
        failureFlag = false;
    }
    public All getAll() {
        return all;
    }

    public Country getCountry() {
        return country;
    }

    public Boolean getFailureFlag() {
        return failureFlag;
    }

    public void newRequest(String params) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi jsonApi = retrofit.create(CovidApi.class);
        Call<All> call = jsonApi.loadData("https://covid-api.mmediagroup.fr/v1/cases?" + params);
        //Log.d("req", "https://covid-api.mmediagroup.fr/v1/cases?" + params);

        call.enqueue(new Callback<All>() {

            @Override
            public void onResponse(Call<All> call, Response<All> response) {
                all = response.body();
                country = all.getCountry();
                //Log.d("all",country.toString());
            }

            @Override
            public void onFailure(Call<All> call, Throwable t) {
                //add toast
                failureFlag = true;
            }
        });
    }

}
