package com.example.aksel.s232324_mappe3;

import android.content.ContentValues;
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

import java.lang.reflect.Field;

/**
 * Created by Aksel on 09/11/2016.
 */

public class Leggtilokt extends AppCompatActivity {

    private TimePicker valg;
    private DatePicker dato;
    private int dag, maaned;
    private Button lagre;
    private EditText okt;
    private DBAdapter db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leggtil_layout);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.trening_ikon);

        db = new DBAdapter(this);
        db.open();

        valg = (TimePicker) findViewById(R.id.klokkeValg);
        valg.setIs24HourView(true);
        okt = (EditText) findViewById(R.id.okt);
        dato = (DatePicker) findViewById(R.id.datoValg);
        lagre = (Button) findViewById(R.id.lagreokten);

        /*try {
            Log.d("test", "test");
            Field f[] = dato.getClass().getDeclaredFields();
            for (Field field : f) {
                if (field.getName().equals("mMonthPicker")) {
                    Log.d("test", "test");
                    field.setAccessible(true);
                    Object yearPicker = new Object();
                    yearPicker = field.get(dato);
                    ((View) yearPicker).setVisibility(View.GONE);
                }
            }
        } catch (SecurityException e) {
            Log.d("ERROR", e.getMessage());
        }
        catch (IllegalArgumentException e) {
            Log.d("ERROR", e.getMessage());
        } catch (IllegalAccessException e) {
            Log.d("ERROR", e.getMessage());
        }*/
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.leggtil_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.lagreokten:
                dag = dato.getDayOfMonth();
                maaned = dato.getMonth();

                ContentValues cv = new ContentValues();
                cv.put(db.TDAG,dag);
                cv.put(db.TMAANED, maaned);
                db.insert(cv);
                //må sendes tilbake til hovedside, med oppdatert view
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
