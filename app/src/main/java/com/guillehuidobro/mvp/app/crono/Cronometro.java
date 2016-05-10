package com.guillehuidobro.mvp.app.crono;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ghuidobro on 10/05/16.
 */
public class Cronometro implements Runnable
{
    // Atributos privados de la clase
    private TextView etiq;                  // Etiqueta para mostrar la información
    private String nombrecronometro;        // Nombre del cronómetro
    private int segundos, minutos, horas;   // Segundos, minutos y horas que lleva activo el cronómetro
    private Handler escribirenUI;           // Necesario para modificar la UI
    private Boolean pausado;                // Para pausar el cronómetro
    private String salida;                  // Salida formateada de los datos del cronómetro
    private Boolean clock;

    /**
     * Constructor de la clase
     * @param nombre Nombre del cronómetro
     * @param etiqueta Etiqueta para mostrar información
     */
    public Cronometro(String nombre, TextView etiqueta)
    {
        etiq = etiqueta;
        salida = "";
        segundos = 0;
        minutos = 0;
        horas = 0;
        nombrecronometro = nombre;
        escribirenUI = new Handler();
        pausado = Boolean.FALSE;
        clock = Boolean.TRUE;
    }

    @Override
    /**
     * Acción del cronómetro, contar tiempo en segundo plano
     */
    public void run()
    {
        try
        {
            while(clock)
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
                    //salida += "0";
                    //salida += horas;
                    //salida += ":";
                    if( minutos <= 9 )
                    {
                       // salida += "0";
                    }
                    //salida += minutos;
                    //salida += ":";
                    if( segundos <= 9 )
                    {
                        salida += "0";
                    }
                    salida += segundos;
                    // Modifico la UI
                    try
                    {
                        escribirenUI.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                etiq.setText(salida);
                            }
                        });
                    }
                    catch (Exception e)
                    {
                        Log.i("Cronometro", "Error en el cronometro " + nombrecronometro + " al escribir en la UI: " + e.toString());
                    }
                }
            }
        }
        catch (InterruptedException e)
        {
            Log.i("Cronometro", "Error en el cronometro " + nombrecronometro + ": " + e.toString());
        }
    }

    /**
     * Reinicia el cronómetro
     */
    public void reiniciar()
    {
        segundos = 0;
        minutos = 0;
        horas = 0;
        pausado = Boolean.FALSE;
    }

    /**
     * Detiene el cronómetro
     */
    public void stop()
    {
        pausado = Boolean.TRUE;
        segundos = 0;
        minutos = 0;
        horas = 0;
        etiq.setText("00");
        clock = Boolean.FALSE;
    }


    /**
     * Pausa/Continua el cronómetro
     */
    public void pause()
    {
        pausado = !pausado;
    }

}
