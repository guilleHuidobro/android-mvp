package com.guillehuidobro.mvp.app.main;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.guillehuidobro.mvp.app.R;
import com.guillehuidobro.mvp.app.crono.CronoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.crono_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.crono_activity:
                startActivity(new Intent(this, CronoActivity.class));
                finish();
                break;

        }
    }
}
