package com.example.catatanbimbingan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.catatanbimbingan.MahasiswaAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static MainActivity ma;
    ApiInterface mApiInterface;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private List<Mahasiswa> listmahasiswa;
    private Button btntambahmahasiswa;
    String[] daftar, daftar2, daftarnim;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    Button btIns;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_mahasiswa);
        mahasiswaAdapter = new MahasiswaAdapter(listmahasiswa);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mahasiswaAdapter);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
//      dbcenter = new DataHelper(this);
        RefreshList();
        //Button Tambah Mahasiswa
        btntambahmahasiswa = findViewById(R.id.btn_tambahmahasiswa);
        btntambahmahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TambahMahasiswaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void RefreshList() {
        Call<GetMahasiswa> mahasiswaCall = mApiInterface.getMahasiswa();
        mahasiswaCall.enqueue(new Callback<GetMahasiswa>() {
            @Override
            public void onResponse(Call<GetMahasiswa> call, Response<GetMahasiswa> response) {
                List<Mahasiswa> listmahasiswa = response.body().getListDataKontak();
                Log.d("Retrofit Get", "Jumlah data mahasiswa: " +
                        String.valueOf(listmahasiswa.size()));
                mAdapter = new MahasiswaAdapter(listmahasiswa);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMahasiswa> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });


    }
}

//        SQLiteDatabase db = dbcenter.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM Mahasiswa", null);
//        daftar = new String[cursor.getCount()];
//        daftar2 = new String[cursor.getCount()];
//        daftarnim = new String[cursor.getCount()];
//        cursor.moveToFirst();
//        for (int cc = 0; cc < cursor.getCount(); cc++) {
//            cursor.moveToPosition(cc);
//            daftar2[cc] = cursor.getString(0).toString();
//            daftar[cc] = cursor.getString(2).toString();
//            daftarnim[cc] = cursor.getString(1).toString();
//        }
//        ListView01 = (ListView) findViewById(R.id.listView1);
//        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
//        ListView01.setSelected(true);
//        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
//                final String selection = daftar2[arg2]; //.getItemAtPosition(arg2).toString();
//                final String selectionnim = daftarnim[arg2];
//                final CharSequence[] dialogitem = {"Lihat Bimbingan","Lihat Biodata", "Update Biodata", "Hapus Biodata"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Pilihan");
//                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int item) {
//                        switch (item) {
//                            case 0:
//                                Intent i1 = new Intent(getApplicationContext(), ListCatatanActivity.class);
//                                i1.putExtra("nim", selectionnim);
//                                startActivity(i1);
//                                break;
//                            case 1:
//                                Intent i = new Intent(getApplicationContext(), LihatBiodataActivity.class);
//                                i.putExtra("id", selection);
//                                startActivity(i);
//                                break;
//                            case 2:
//                                Intent in = new Intent(getApplicationContext(), UpdateMahasiswaActivity.class);
//                                in.putExtra("nim", selectionnim);
//                                startActivity(in);
//                                break;
//                            case 3:
//                                SQLiteDatabase db = dbcenter.getWritableDatabase();
//                                db.execSQL("delete from Mahasiswa where id = '" + selection + "'");
//                                RefreshList();
//                                break;
//                        }
//                    }
//                });
//                builder.create().show();
//            }
//        });
//        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();