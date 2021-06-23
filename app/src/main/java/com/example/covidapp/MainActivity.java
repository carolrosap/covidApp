package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Pais;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Map<String, String>> lista;
    private TextView textView;
    private  Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.covid_app);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle(getResources().getString(R.string.app_name));

        textView = findViewById(R.id.txtView);

        lista = new ArrayList<>();
        Pais pais = new Pais();

        //AsyncHttpClient client = new AsyncHttpClient();
        //RequestParams params = new RequestParams("country", "Global");

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-api.mmediagroup.fr/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi jsonApi = retrofit.create(CovidApi.class);
        Call<All> call = jsonApi.loadData("https://covid-api.mmediagroup.fr/v1/cases?country=Global");

        call.enqueue(new Callback<All>(){

            @Override
            public void onResponse(Call<All> call, Response<All> response) {
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<All> call, Throwable t) {

            }
        });

        /*client.get("https://covid-api.mmediagroup.fr/v1/cases", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                String data = new String(response);
                try {
                    loadData(data);
                    Toast.makeText(getApplicationContext(),data ,Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

}