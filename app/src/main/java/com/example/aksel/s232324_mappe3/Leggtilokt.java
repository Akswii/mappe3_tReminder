package com.example.aksel.s232324_mappe3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by Aksel on 09/11/2016.
 */

public class Leggtilokt extends AppCompatActivity {

    private TimePicker valg;
    private DatePicker dato;
    private int dag, maaned;
    private Button lagre;
    private EditText okt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leggtil_layout);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.trening_ikon);

        valg = (TimePicker) findViewById(R.id.klokkeValg);
        valg.setIs24HourView(true);
        okt = (EditText) findViewById(R.id.okt);
        dato = (DatePicker) findViewById(R.id.datoValg);
        lagre = (Button) findViewById(R.id.lagreokten);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.leggtil_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.lagreokten:
                String treningsokt = okt.getText().toString();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
