package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.covidapp.model.All;
import com.example.covidapp.model.Country;
import com.example.covidapp.model.CountryAll;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListActivity extends  AppCompatActivity{

    


        RetrofitConfig config = new RetrofitConfig();
        Call<Object> call = config.getService().loadCountryAll(config.getUrlBase () + "cases?country=All");
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object body = response.body();
                Gson gson = new Gson();
                String s = gson.toJson(body);
                Map<String, All> map = gson.fromJson(s, Map.class);
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, All> entry = (Map.Entry)iterator.next();
                    String dados = String.valueOf(entry.getValue());
                    Log.d("VAI", dados);
                    String pais = getStringAt("country", dados);
                    if(!pais.contains("=")){
                        String confirmed = getStringAt("confirmed", dados);
                        String deaths = getStringAt("deaths", dados);
                        String recovered = getStringAt("country", dados);
                        String population = getStringAt("population", dados);
                    }

                }

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {


            }
        });




    }
    private String getStringAt(String search, String dados) {
        int t = search.length()+1;
        int dadosF = dados.lastIndexOf(search) + t;
        int virgulas = 0;
        int tam = dados.length();
        for (int i = dadosF; i < tam; i++) {
            if(dados.charAt(i) == ','){
                virgulas = i ;
                break;
            }

        }
        Log.d("f: ", String.valueOf(dadosF));
        Log.d("vir: ", String.valueOf(virgulas));

        String retorno = dados.substring(dadosF, virgulas);
        Log.d("retorno", retorno);

        return retorno;


    }
}
