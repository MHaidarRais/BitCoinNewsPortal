package com.rais.haidar.bitcoinnewsportal.main.view;

import com.rais.haidar.bitcoinnewsportal.Base.BaseView;
import com.rais.haidar.bitcoinnewsportal.main.model.ArticlesItem;
import com.rais.haidar.bitcoinnewsportal.main.model.ResponseBerita;

import java.util.List;

public interface MainView extends BaseView {
    void onSuccess(List<ArticlesItem> data);
    void onError(String msg);
}
