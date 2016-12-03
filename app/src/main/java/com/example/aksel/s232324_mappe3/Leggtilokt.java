package com.example.aksel.s232324_mappe3;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by Aksel on 09/11/2016.
 */

public class Leggtilokt extends AppCompatActivity {

    private TimePicker valg;
    private DatePicker dato;
    private EditText okt;
    private DBAdapter db;
    private int dag, maaned, timer, minutt;
    private String kroppsDel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leggtil_layout);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new DBAdapter(this);
        db.open();

        valg = (TimePicker) findViewById(R.id.klokkeValg);
        valg.setIs24HourView(true);
        okt = (EditText) findViewById(R.id.okt);
        dato = (DatePicker) findViewById(R.id.datoValg);
        dato.setMinDate(System.currentTimeMillis() - 1000);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.leggtil_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        Context thisC = this;
        switch(item.getItemId()){
            case R.id.lagreokten:
                dag = dato.getDayOfMonth();
                maaned = dato.getMonth();
                kroppsDel = okt.getText().toString();
                timer = valg.getCurrentHour();
                minutt = valg.getCurrentMinute();

                Log.d("Timer og minutter ", timer + " " + minutt);

                ContentValues cv = new ContentValues();
                cv.put(db.KROPPSDEL, kroppsDel);
                cv.put(db.TDAG,dag);
                cv.put(db.TMAANED, maaned);
                cv.put(db.TIMEN, timer);
                cv.put(db.MINUTT, minutt);
                db.insert(cv);
                Toast.makeText(this, "Ny treningsøkt registrert!", Toast.LENGTH_SHORT).show();
                intent = new Intent(thisC, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
