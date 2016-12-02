package com.example.aksel.s232324_mappe3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.trening_ikon);

        DBAdapter db = new DBAdapter(this);
        db.open();

        ContentValues cv = new ContentValues();
        cv.put(db.KROPPSDEL, "kasse");
        cv.put(db.ADRESSE, "..");
        cv.put(db.TDAG, 02);
        cv.put(db.TMAANED, 11);
        cv.put(db.TAAR, 2016);

        db.insert(cv);

        GridView gridView = (GridView) findViewById(R.id.ukesview);

        String[] test = new String[]{"Test", "Hei", "Hade"};

        final List<String> dagListe = new ArrayList<String>();
        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dagListe);

        gridView.setAdapter(gridViewArrayAdapter);

        Cursor cur = db.visalleDager();
        if(cur.moveToFirst()){
            do {
                dagListe.add(dagListe.size(), cur.getString(2) + "" /*+ " " + cur.getString(1)*/);
                gridViewArrayAdapter.notifyDataSetChanged();
                //tallListe.add(cur.getInt(6));
                Log.d("Testy", "test");
            }while(cur.moveToNext());
        }
        cur.close();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hoved_meny,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch(item.getItemId()){
            case R.id.Leggtil:
                intent = new Intent(MainActivity.this, Leggtilokt.class);
                startActivity(intent);
                return true;
            case R.id.prefs:
                intent = new Intent(MainActivity.this,Instillinger.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
