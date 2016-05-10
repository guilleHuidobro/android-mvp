package com.guillehuidobro.mvp.app.crono;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ghuidobro on 10/05/16.
 */
public class CronoPresenterImpl implements CronoPresenter{

    CronoView cronoView;
    private Cronometro cronometro = null;

    public CronoPresenterImpl(CronoView cronoView){
        this.cronoView = cronoView;
    }

    @Override
    public void startThread(TextView tCronometro1) {
        Log.d(null,"GUILLE --- LOGUEANDO EL START Thread");
        if (cronoView != null){
            cronoView.showMessage("GUILLE --- START Thread");

            cronometro = new Cronometro("Cronómetro", tCronometro1);
            new Thread(cronometro).start();
        }

    }

    @Override
    public void startAsyncTask() {
        Log.d(null,"GUILLE --- LOGUEANDO EL START AsyncTask");
        if (cronoView != null) {
            cronoView.showMessage("GUILLE --- START AsyncTask");

            AsyncTaskCrono task = new AsyncTaskCrono();
            task.execute();
        }
    }

    @Override
    public void stopThread() {
        Log.d(null,"GUILLE --- LOGUEANDO EL STOP Thread");
            if (cronoView != null) {
                cronoView.showMessage("GUILLE --- STOP Thread");
                cronometro.stop();
            }
    }

    @Override
    public void stopAsyncTask() {
        Log.d(null,"GUILLE --- LOGUEANDO EL STOP AsyncTask");
                if (cronoView != null) {
                    cronoView.showMessage("GUILLE --- STOP AsyncTask");
                }
    }
}
