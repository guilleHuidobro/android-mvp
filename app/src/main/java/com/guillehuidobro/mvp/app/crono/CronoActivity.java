package com.guillehuidobro.mvp.app.crono;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.guillehuidobro.mvp.app.R;


public class CronoActivity extends AppCompatActivity implements CronoView , View.OnClickListener{

    private CronoPresenter presenter;
    private static TextView tCronometro1;
    private static TextView tCronometro2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);

        findViewById(R.id.thread_button).setOnClickListener(this);
        findViewById(R.id.stop_thread_button).setOnClickListener(this);
        findViewById(R.id.async_button).setOnClickListener(this);
        findViewById(R.id.stop_async_button).setOnClickListener(this);

        tCronometro1 = (TextView)findViewById(R.id.tCronometro1);
        tCronometro2 = (TextView)findViewById(R.id.tCronometro2);

        presenter = new CronoPresenterImpl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.async_button:
                Log.d(null,"GUILLE --- LOGUEANDO EL START AsyncTask");
                presenter.startAsyncTask();
                break;
            case R.id.stop_async_button:
                Log.d(null,"GUILLE --- LOGUEANDO EL STOP AsyncTask");
                presenter.stopAsyncTask();
                break;
            case R.id.thread_button:
                Log.d(null,"GUILLE --- LOGUEANDO EL START Thread");
                presenter.startThread(tCronometro1);
                break;
            case R.id.stop_thread_button:
                Log.d(null,"GUILLE --- LOGUEANDO EL START Thread");
                presenter.stopThread();
                break;
        }

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startThread() {

    }


    @Override
    public void startAsyncTask() {

    }

    @Override
    public void stopThread() {

    }

    @Override
    public void stopAsyncTask() {

    }


}
