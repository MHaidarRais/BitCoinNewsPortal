package com.rais.haidar.bitcoinnewsportal.main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rais.haidar.bitcoinnewsportal.Base.BaseView;
import com.rais.haidar.bitcoinnewsportal.R;
import com.rais.haidar.bitcoinnewsportal.main.model.ArticlesItem;
import com.rais.haidar.bitcoinnewsportal.main.model.ResponseBerita;
import com.rais.haidar.bitcoinnewsportal.main.presenter.MainPresenter;
import com.rais.haidar.bitcoinnewsportal.main.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcView = findViewById(R.id.rcView);
        mainPresenter = new MainPresenter();
        onAttachView();

    }


    @Override
    public void onSuccess(List<ArticlesItem> data) {
        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setAdapter(new MainAdapter(MainActivity.this,data));
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttachView() {
       mainPresenter.onAttach(this);
       mainPresenter.getData();
    }

    @Override
    public void onDetachView() {

    }
}
