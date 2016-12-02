package com.example.aksel.s232324_mappe3;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        DBAdapter db = new DBAdapter(this);
        db.open();



        GridView gridView = (GridView) findViewById(R.id.ukesview);

        String[] test = new String[]{"Test", "Hei", "Hade"};

        final List<String> dagListe = new ArrayList<String>(Arrays.asList(test));
        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dagListe);

        gridView.setAdapter(gridViewArrayAdapter);

        Cursor cur = db.visalleDager();
        if(cur.moveToFirst()){
            do {
                dagListe.add(dagListe.size(), cur.getString(0) + "" /*+ " " + cur.getString(1)*/);
                gridViewArrayAdapter.notifyDataSetChanged();
                //tallListe.add(cur.getInt(6));
                Log.d("Testy", "test");
            }while(cur.moveToNext());
        }
        cur.close();

    }
}
