package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Country;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView population, deaths, confirmed, recovered;
    private CovidApiService service = new CovidApiService();

    //private  Retrofit retrofit;
    private All all = new All();
    private  Country country = new Country();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.covid_app);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle(getResources().getString(R.string.app_name));

        population = findViewById(R.id.population);
        recovered = findViewById(R.id.recovered);
        deaths = findViewById(R.id.deaths);
        confirmed = findViewById(R.id.confirmed);

        service.newRequest("country=Global");
        if(!service.getFailureFlag()) {
            country =  all.getCountry();
            Log.d("pop", country.toString());
            population.setText(String.valueOf(country.getPopulation()));
            deaths.setText(String.valueOf(country.getPopulation()));
            recovered.setText(String.valueOf(country.getRecovered()));
            confirmed.setText(String.valueOf(country.getConfirmed()));
        }


    }

}