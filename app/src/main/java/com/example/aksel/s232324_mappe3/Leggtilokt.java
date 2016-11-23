package com.example.aksel.s232324_mappe3;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.lang.reflect.Field;
import java.util.Calendar;

/**
 * Created by Aksel on 09/11/2016.
 */

public class Leggtilokt extends AppCompatActivity {

    private TimePicker valg;
    private Calendar klslett;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leggtil_layout);
        getSupportActionBar().setTitle("");

        valg = (TimePicker) findViewById(R.id.klokkeValg);
        valg.setIs24HourView(true);
    }
}
