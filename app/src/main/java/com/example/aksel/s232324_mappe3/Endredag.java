package com.example.aksel.s232324_mappe3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by Aksel on 02/12/2016.
 */

public class Endredag extends AppCompatActivity {
    private TimePicker valg;
    private DatePicker dato;
    private EditText okt;
    private String kroppsDel;
    private DBAdapter db;
    private int iden,dag,maaned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endre_layout);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new DBAdapter(this);
        db.open();

        valg = (TimePicker) findViewById(R.id.klokkeEndre);
        valg.setIs24HourView(true);
        okt = (EditText) findViewById(R.id.oktEndre);
        dato = (DatePicker) findViewById(R.id.datoEndre);
        dato.setMinDate(System.currentTimeMillis() - 1000);

        Intent mIntent = getIntent();
        iden = mIntent.getIntExtra("Posnr", 0);

        Cursor cur;
        cur = db.finndag(iden);
        if (cur.moveToFirst()) {
            do {
                okt.setText(cur.getString(0));
                valg.setCurrentHour(cur.getInt(1));
                Log.d("Time", ""+cur.getInt(1));
                valg.setCurrentMinute(cur.getInt(2));
                dato.updateDate(cur.getInt(5), cur.getInt(4), cur.getInt(3));
            }while(cur.moveToNext());
        }
        cur.close();
    }
}