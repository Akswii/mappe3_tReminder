package com.example.aksel.s232324_mappe3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aksel on 16/11/2016.
 */

public class DBAdapter {
    static final String TAG="";
    static final String DB_NAVN="Treningsdagbok";
    static final String TABELL="Persliste";
    static final String KROPPSDEL = "kroppsdel";
    static final String TDAG="dag", TMAANED="maaned", TAAR="aar", TIMEN="time", MINUTT="minutt";
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
                    + KROPPSDEL + " TEXT, "
                    + TIMEN + " TEXT ,"
                    + MINUTT + " TEXT ,"
                    + TDAG + " TEXT, "
                    + TMAANED + " TEXT, "
                    + TAAR + " TEXT)";
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

    public boolean oppdaterDag(String kroppsdel, int dag, int maaned, int aar, int timen, int minutt, int iden){
        ContentValues cv = new ContentValues();
        cv.put(KROPPSDEL, kroppsdel);
        cv.put(TIMEN, timen);
        cv.put(MINUTT, minutt);
        cv.put(TDAG, dag);
        cv.put(TMAANED, maaned);
        cv.put(TAAR, aar);
        return db.update(TABELL,cv,ID+"="+"'"+iden+"'",null)>0;
    }

    public Cursor visalleDager(){
        String[] cols={KROPPSDEL,TDAG,TMAANED,ID};
        Cursor cur = db.query(TABELL, cols,null,null,null,null,TAAR + " , " + TMAANED + " , " + TDAG);
        return cur;
    }

    public Cursor finndag(int i){
        String[] cols = {KROPPSDEL, TIMEN, MINUTT, TDAG, TMAANED, TAAR};
        return db.query(TABELL, cols, ID + "='" + i + "'", null, null, null, null);
    }
}
