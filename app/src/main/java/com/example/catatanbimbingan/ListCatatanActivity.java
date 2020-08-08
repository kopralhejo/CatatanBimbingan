package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.catatanbimbingan.Adapter.MahasiswaAdapter;
import com.example.catatanbimbingan.Model.Catatan;
import com.example.catatanbimbingan.Model.Mahasiswa;
import com.example.catatanbimbingan.RestApi.ApiClient;
import com.example.catatanbimbingan.RestApi.ApiInterface;
import com.example.catatanbimbingan.RestApi.GetCatatan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListCatatanActivity extends AppCompatActivity {

    private Button btntambahmahasiswa;
    String nim;
    public static ListCatatanActivity ma;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> listCatatan;
    String[] daftar, daftar2, daftarnim;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    ApiInterface mApiInterface;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_catatan);

        final Intent mIntent = getIntent();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        nim = mIntent.getStringExtra("nim");
//        dbcenter = new DataHelper(this);
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
//        SQLiteDatabase db = dbcenter.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM Catatan", null);
//        cursor = db.rawQuery("SELECT * FROM Catatan WHERE nim = '"+getIntent().getStringExtra("nim")+"'", null);
//        daftar = new String[cursor.getCount()];
//        daftar2 = new String[cursor.getCount()];
//        daftarnim = new String[cursor.getCount()];
//        cursor.moveToFirst();
//        for (int cc = 0; cc < cursor.getCount(); cc++) {
//            cursor.moveToPosition(cc);
//            daftar2[cc] = cursor.getString(0).toString();
//            daftar[cc] = "bimbingan ke - " + cursor.getString(3).toString();
//            daftarnim[cc] = cursor.getString(1).toString();
//        }
        Call<GetCatatan> catatanCall = mApiInterface.getCatatan(
                nim);
        catatanCall.enqueue(new Callback<GetCatatan>() {
            @Override
            public void onResponse(Call<GetCatatan> call, Response<GetCatatan> response) {
                List<Catatan> listCatatan = new ArrayList<>();
                listCatatan = response.body().getListDataKontak();
                Log.d("Retrofit Get", "Catatan ????: " +
                        String.valueOf(listCatatan.size()));
                for (int i = 0; i < listCatatan.size(); i++){
                    daftar[i] = "bimbingan ke - " + listCatatan.get(i).getBimbingan();
                    Log.d("Retrofit Get", "Catatan: " +
                            String.valueOf(listCatatan.get(i).getBimbingan()));
                }
            }

            @Override
            public void onFailure(Call<GetCatatan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
//        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
//                final String selection = daftar2[arg2]; //.getItemAtPosition(arg2).toString();
//                final String selectionnim = daftarnim[arg2];
//                final CharSequence[] dialogitem = {"Lihat Catatan","X Update Biodata", "X Hapus Biodata"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(ListCatatanActivity.this);
//                builder.setTitle("Pilihan");
//                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int item) {
//                        switch (item) {
//                            case 0:
//                                Intent i1 = new Intent(getApplicationContext(), EditCatatanActivity.class);
//                                i1.putExtra("id", selection);
//                                startActivity(i1);
//                                break;
//                            case 1:
//                                Intent i = new Intent(getApplicationContext(), LihatBiodataActivity.class);
//                                i.putExtra("id", selection);
//                                startActivity(i);
//                                break;
//                            case 2:
//                                Intent in = new Intent(getApplicationContext(), LihatBiodataActivity.class);
//                                in.putExtra("id", selection);
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
//        ListView01 = (ListView) findViewById(R.id.listView1);
//        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
//        ListView01.setSelected(true);
//        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}