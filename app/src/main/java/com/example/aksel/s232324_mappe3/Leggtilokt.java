package com.example.aksel.s232324_mappe3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TimePicker;
import java.util.Calendar;

/**
 * Created by Aksel on 09/11/2016.
 */

public class Leggtilokt extends AppCompatActivity {

    private TimePicker valg;
    private Button lagre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leggtil_layout);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.trening_ikon);

        valg = (TimePicker) findViewById(R.id.klokkeValg);
        valg.setIs24HourView(true);


    }
}
