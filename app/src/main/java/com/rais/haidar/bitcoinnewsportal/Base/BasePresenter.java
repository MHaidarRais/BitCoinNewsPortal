package com.rais.haidar.bitcoinnewsportal.Base;

public interface BasePresenter <T extends BaseView> {
    void onAttach(T v);
    void onDetach();
}
