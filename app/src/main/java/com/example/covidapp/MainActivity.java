package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Observable;
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

import static java.util.concurrent.TimeUnit.SECONDS;

public class MainActivity extends AppCompatActivity {

    private TextView population, deaths, confirmed, recovered;
    private CovidApiService service = new CovidApiService();
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
        service.getCall().enqueue(new Callback<All>() {
            @Override
            public void onResponse(Call<All> call, Response<All> response) {
                all = response.body();
                country = all.getCountry();
                country =  all.getCountry();
                Log.d("pop", country.toString());
                population.setText(String.valueOf(country.getPopulation()));
                deaths.setText(String.valueOf(country.getDeaths()));
                recovered.setText(String.valueOf(country.getRecovered()));
                confirmed.setText(String.valueOf(country.getConfirmed()));
            }

            @Override
            public void onFailure(Call<All> call, Throwable t) {
                //add toast
                //failureFlag = true;
            }
        });

        
    }

}