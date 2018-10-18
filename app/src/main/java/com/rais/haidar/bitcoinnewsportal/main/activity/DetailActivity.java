package com.rais.haidar.bitcoinnewsportal.main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rais.haidar.bitcoinnewsportal.R;

public class DetailActivity extends AppCompatActivity {

    TextView txtDetailJudul,txtDetailAuthor,txtDetailDeskripsi;
    ImageView imgDetailBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetailAuthor = findViewById(R.id.txtDetailAuthor);
        txtDetailJudul = findViewById(R.id.txtDetailJudul);
        txtDetailDeskripsi = findViewById(R.id.txtDetailDeskripsi);
        imgDetailBerita = findViewById(R.id.detailImgBerita);

        String detailAuthor = getIntent().getStringExtra("detailAuthor");
        String detailJudul = getIntent().getStringExtra("detailTitle");
        String detailDeskripsi = getIntent().getStringExtra("detailDeskripsi");
        String detailGambar = getIntent().getStringExtra("detailGambar");

        txtDetailAuthor.setText(detailAuthor);
        txtDetailJudul.setText(detailJudul);
        txtDetailDeskripsi.setText(detailDeskripsi);

        Glide.with(this)
                .load(detailGambar)
                .into(imgDetailBerita);


    }
}
