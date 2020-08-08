package com.example.catatanbimbingan.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    //DATABASE NAME
    public static final String DATABASE_NAME = "dosen4";
    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db){
        String sql2 = "Create table Catatan(id integer primary key,judul text null,nim text null,bimbingan integer null,catatan text null,tanggal DATETIME DEFAULT CURRENT_TIMESTAMP)";
        Log.d("Data","onCreate: "+sql2);
        db.execSQL(sql2);

        String sql = "create table Mahasiswa(id integer primary key, nim text null, nama text null, hp text null,prodi text null,angkatan text null,jumlahbimbingan text null,tanggal text null)";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        arg0.execSQL(" DROP TABLE IF EXISTS " + "Mahasiswa");
    }
}
