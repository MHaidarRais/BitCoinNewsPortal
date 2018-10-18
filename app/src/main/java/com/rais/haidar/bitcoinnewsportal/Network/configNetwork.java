package com.rais.haidar.bitcoinnewsportal.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class configNetwork {
    public static final String WebUrl = "https://newsapi.org/v2/";

    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(WebUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}
