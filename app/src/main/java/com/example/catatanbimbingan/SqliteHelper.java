//package com.example.catatanbimbingan;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import static android.accounts.AccountManager.KEY_PASSWORD;
//
//
//public class SqliteHelper extends SQLiteOpenHelper {
//
//    //DATABASE NAME
//    public static final String DATABASE_NAME = "catatandosen";
//
//    //DATABASE VERSION
//    public static final int DATABASE_VERSION = 1;
//
//    //TABLE NAME
//    public static final String TABLE_Mahasiswa = "Mahasiswa";
//
//    //TABLE Mahasiswa COLUMNS
//    //ID COLUMN @primaryKey
//    public static final String KEY_ID = "id";
//    public static final String KEY_NIM = "nim";
//    public static final String KEY_HP = "hp";
//    public static final String KEY_NAMA = "nama";
//    public static final String KEY_JURUSAN = "jurusan";
//    public static final String KEY_ANGKATAN = "angkatan";
//    public static final String KEY_JUMLAHBIMBINGAN = "jumlahbimbingan";
//    public static final String KEY_TANGGAL = "tanggal";
//
//
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
//
//
//    public SqliteHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        //Create Table when oncreate gets called
//        sqLiteDatabase.execSQL(SQL_TABLE_Mahasiswa);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        //drop table to create new one if database version updated
//        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_Mahasiswa);
//    }
//
//    //using this method we can add Mahasiswa to user table
//    public void addMahasiswa(Mahasiswa user) {
//
//        //get writable database
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        //create content values to insert
//        ContentValues values = new ContentValues();
//
//        values.put(KEY_NIM, user.nim);
//        values.put(KEY_NAMA, user.nama);
//        values.put(KEY_HP, user.hp);
//        values.put(KEY_JURUSAN, user.jurusan);
//        values.put(KEY_ANGKATAN, user.angkatan);
//        values.put(KEY_JUMLAHBIMBINGAN, user.jmlbimbingan);
//        values.put(KEY_TANGGAL, user.tanggal);
//
//        // insert row
//        long todo_id = db.insert(TABLE_Mahasiswa, null, values);
//    }
//
//}