package com.example.aksel.s232324_mappe3;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aksel on 16/11/2016.
 */

public class DBAdapter {
    // okei!?
    static final String TAG="";
    static final String DB_NAVN="Treningsdagbok";
    static final String TABELL="Persliste";
    static final String ADRESSE="adresse";
    static final String TDAG="dag", TMAANED="maaned", TAAR="aar";
    static final String ID="id";
    static final int DB_VERSJON=1;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private Context context;

    public DBAdapter(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,DB_NAVN,null,DB_VERSJON);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql="CREATE TABLE " + TABELL + "("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ADRESSE + " TEXT, "
                    + TDAG + " TEXT, "
                    + TMAANED + " TEXT, "
                    + TAAR + " TEXT)"; //kanskje fjerne år, siden jeg tenker at de kun kan lage plan for en uke
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + TABELL);
            onCreate(db);
        }
    }

    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close(){}

    public void insert(ContentValues cv){
        db.insert(TABELL,null,cv);
    }

    public boolean slett(int id){
        return db.delete(TABELL, ID + "='" + id + "'", null) > 0;
    }

    public boolean oppdater(){return false;}
}
