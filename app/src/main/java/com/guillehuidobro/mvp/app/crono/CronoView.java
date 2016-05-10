package com.guillehuidobro.mvp.app.crono;

/**
 * Created by ghuidobro on 10/05/16.
 */
public interface CronoView {
    void showMessage(String message);
    void startThread();
    void startAsyncTask();
    void stopThread();
    void stopAsyncTask();
}
