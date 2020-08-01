package com.example.catatanbimbingan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    //DATABASE NAME
    public static final String DATABASE_NAME = "dosen";
    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;
    //TABLE NAME
//    public static final String TABLE_Mahasiswa = "Mahasiswa";
//    //ID COLUMN @primaryKey
//    public static final String KEY_ID = "id";
//    public static final String KEY_NIM = "nim";
//    public static final String KEY_HP = "hp";
//    public static final String KEY_NAMA = "nama";
//    public static final String KEY_JURUSAN = "jurusan";
//    public static final String KEY_ANGKATAN = "angkatan";
//    public static final String KEY_JUMLAHBIMBINGAN = "jumlahbimbingan";
//    public static final String KEY_TANGGAL = "tanggal";
//    //SQL for creating Mahasiswa table
//    public static final String SQL_TABLE_Mahasiswa = " CREATE TABLE " + TABLE_Mahasiswa
//            + " ( "
//            + KEY_ID + " INTEGER PRIMARY KEY, "
//            + KEY_NIM + " TEXT, "
//            + KEY_NAMA + " TEXT, "
//            + KEY_HP + " TEXT,"
//            + KEY_JURUSAN + "TEXT,"
//            + KEY_ANGKATAN + " TEXT,"
//            + KEY_JUMLAHBIMBINGAN + " INTEGER,"
//            + KEY_TANGGAL + "DATE"
//            + " ) ";

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
//    public void onCreate(SQLiteDatabase db){
//        db.execSQL(SQL_TABLE_Mahasiswa);
//    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table Mahasiswa(" +
                "id integer primary key, " +
                "nim text null, " +
                "nama text null, " +
                "hp text null, " +
                "prodi text null," +
                "angkatan text null, " +
                "jumlahbimbingan text null, " +
                "tanggal text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        arg0.execSQL(" DROP TABLE IF EXISTS " + "Mahasiswa");
    }
}
