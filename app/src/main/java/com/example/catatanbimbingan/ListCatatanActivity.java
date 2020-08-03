package com.example.catatanbimbingan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ListCatatanActivity extends AppCompatActivity {

    private Button btntambahmahasiswa;
    String nim;
    public static ListCatatanActivity ma;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> listmahasiswa;
    String[] daftar, daftar2, daftarnim;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_catatan);
        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();

        btntambahmahasiswa = findViewById(R.id.btn_tambahmahasiswa);
        btntambahmahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim = getIntent().getStringExtra("nim");
                Intent intent = new Intent(ListCatatanActivity.this, TambahCatatanActivity.class);
                intent.putExtra("nim", nim);
                startActivity(intent);
            }
        });
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM Catatan", null);
        cursor = db.rawQuery("SELECT * FROM Catatan WHERE nim = '"+getIntent().getStringExtra("nim")+"'", null);
        daftar = new String[cursor.getCount()];
        daftar2 = new String[cursor.getCount()];
        daftarnim = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar2[cc] = cursor.getString(0).toString();
            daftar[cc] = "bimbingan ke - " + cursor.getString(3).toString();
            daftarnim[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView) findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar2[arg2]; //.getItemAtPosition(arg2).toString();
                final String selectionnim = daftarnim[arg2];
                final CharSequence[] dialogitem = {"Lihat Catatan","X Update Biodata", "X Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ListCatatanActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i1 = new Intent(getApplicationContext(), EditCatatanActivity.class);
                                i1.putExtra("id", selection);
                                startActivity(i1);
                                break;
                            case 1:
                                Intent i = new Intent(getApplicationContext(), LihatBiodataActivity.class);
                                i.putExtra("id", selection);
                                startActivity(i);
                                break;
                            case 2:
                                Intent in = new Intent(getApplicationContext(), LihatBiodataActivity.class);
                                in.putExtra("id", selection);
                                startActivity(in);
                                break;
                            case 3:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from Mahasiswa where id = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}