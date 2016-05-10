package com.guillehuidobro.mvp.app.crono;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ghuidobro on 10/05/16.
 */
public class AsyncTaskCrono extends AsyncTask<Void, Integer, Message> {

    private final String TAG = AsyncTaskCrono.class.getName();

    private int segundos, minutos, horas;
    private Boolean pausado= Boolean.FALSE;
    private String salida;
    private Handler mostrar = new Handler();

    protected void onPreExecute() {
        Log.d(TAG, "On preExceute...");
    }

    protected Message doInBackground(Void... arg0) {
        Log.d(TAG, "On doInBackground...");

            try {
                Log.d(TAG, "Starting receiving...");
                Thread t = new Thread(new Runnable(){
                    public void run() {
                        try {

                            while(Boolean.TRUE)
                            {
                                Thread.sleep(1000);
                                salida = "";
                                if( !pausado )
                                {
                                    segundos++;
                                    if(segundos == 60)
                                    {
                                        segundos = 0;
                                        minutos++;
                                    }
                                    if(minutos == 60)
                                    {
                                        minutos = 0;
                                        horas++;
                                    }
                                    // Formateo la salida
                                    salida += "0";
                                    salida += horas;
                                    salida += ":";
                                    if( minutos <= 9 )
                                    {
                                        salida += "0";
                                    }
                                    salida += minutos;
                                    salida += ":";
                                    if( segundos <= 9 )
                                    {
                                        salida += "0";
                                    }
                                    salida += segundos;
                                    // Modifico la UI
                                    try
                                    {
                                        mostrar.post(new Runnable()
                                        {
                                            @Override
                                            public void run()
                                            {
                                                Log.d(TAG,salida);
                                            }
                                            });
                                    }
                                    catch (Exception e)
                                    {
                                        Log.d("Cronometro", "Error en el handler: " + e);
                                    }
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
                t.join();

            } catch (Exception e) {
                e.printStackTrace();
            }

        return null;
    }

    protected void onProgressUpdate(Integer... a) {
        Log.d(TAG, "You are in progress onProgressUpdate ... " + a[0]);
    }

    protected void onPostExecute(Message result) {
        Log.d(TAG, "You are in progress onPostExecute: " + result);
    }
}