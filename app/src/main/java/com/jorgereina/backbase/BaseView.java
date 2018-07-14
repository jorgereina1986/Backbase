package com.jorgereina.backbase;

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showError(String errorMessage);
}
