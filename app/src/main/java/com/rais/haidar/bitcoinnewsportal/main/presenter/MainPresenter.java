package com.rais.haidar.bitcoinnewsportal.main.presenter;

import com.rais.haidar.bitcoinnewsportal.Base.BasePresenter;
import com.rais.haidar.bitcoinnewsportal.Network.configNetwork;
import com.rais.haidar.bitcoinnewsportal.main.model.ArticlesItem;
import com.rais.haidar.bitcoinnewsportal.main.model.ResponseBerita;
import com.rais.haidar.bitcoinnewsportal.main.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String apikey = "5h30dB4K4Uwuhj4KkmHmFkrBzQHtf2wGPVQSARoCa+HgMHZRk0/vFn0ZKpFDgc1KYy/F7LEE8nAOHhKgru6btQ==";

    public Call<ResponseBerita> call() {
        return configNetwork.getInstance().getBerita();
    }

    public void getData(){
        call().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.body().getStatus().equalsIgnoreCase("ok")){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSuccess(articlesItems);
                }else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }
}
