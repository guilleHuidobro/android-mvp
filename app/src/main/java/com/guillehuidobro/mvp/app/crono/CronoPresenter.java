package com.guillehuidobro.mvp.app.crono;

import android.widget.TextView;

/**
 * Created by ghuidobro on 10/05/16.
 */
public interface CronoPresenter {
    void startThread(TextView tCronometro1);
    void startAsyncTask();
    void stopThread();
    void stopAsyncTask();
}
