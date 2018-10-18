package com.rais.haidar.bitcoinnewsportal.Network;

import com.rais.haidar.bitcoinnewsportal.main.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("everything?q=bitcoin&from=2018-09-18&sortBy=publishedAt&apiKey=742f9c39ed6c4d5c8874aadb10b34b79")
    Call<ResponseBerita> getBerita(
    );
}
