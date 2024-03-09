package com.example.retrofitrecyclerview.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.18:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
