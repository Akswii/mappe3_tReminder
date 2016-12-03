package com.example.aksel.s232324_mappe3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Aksel on 02/12/2016.
 */

public class Endredag extends AppCompatActivity{
    private DBAdapter db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.endre_layout);
        getSupportActionBar().setTitle("");

        /*db = new DBAdapter(this);
        db.open();

        Intent mIntent = getIntent();
        //iden = mIntent.getIntExtra("Posnr", 0);

        Cursor cur;
        cur = db.finndag(iden);
        if(cur.moveToFirst())
        {
            do{
                /*fornavn.setText(cur.getString(0));
                etternavn.setText(cur.getString(1));
                telefonnummer.setText(cur.getString(2));
                dato.updateDate(cur.getInt(5), cur.getInt(4), cur.getInt(3));
            }while(cur.moveToNext());
        }
        cur.close();*/
    }
}
