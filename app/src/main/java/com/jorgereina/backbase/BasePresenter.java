package com.jorgereina.backbase;

import android.support.annotation.NonNull;

public class BasePresenter<V> {

    protected V view;

    public final void attachView(@NonNull V view) {
        this.view = view;
    }

    public final void detachView() {
        view = null;
    }

    protected final boolean isViewAttached() {
        return view != null;
    }

}
