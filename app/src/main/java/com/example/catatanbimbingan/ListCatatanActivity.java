package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.catatanbimbingan.Adapter.CatatanAdapter;
import com.example.catatanbimbingan.Adapter.MahasiswaAdapter;
import com.example.catatanbimbingan.Model.Catatan;
import com.example.catatanbimbingan.Model.Mahasiswa;
import com.example.catatanbimbingan.RestApi.ApiClient;
import com.example.catatanbimbingan.RestApi.ApiInterface;
import com.example.catatanbimbingan.RestApi.GetCatatan;
import com.example.catatanbimbingan.RestApi.GetMahasiswaId;
import com.example.catatanbimbingan.RestApi.GetMahasiswaId;
import com.example.catatanbimbingan.RestApi.GetMahasiswaId;
import com.example.catatanbimbingan.Sql.DataHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListCatatanActivity extends AppCompatActivity {

    private Button btntambahmahasiswa;
    public String nim;
    public static ListCatatanActivity ma;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> listCatatan;
    String jumlahbimbing,satu,dua;
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

        recyclerView = findViewById(R.id.list_mahasiswa);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListCatatanActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        final Intent mIntent = getIntent();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        nim = mIntent.getStringExtra("nim");

        RefreshList();

        btntambahmahasiswa = findViewById(R.id.btn_tambahmahasiswa);
        btntambahmahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ListCatatanActivity.this, TambahCatatanActivity.class);
                intent.putExtra("nim", nim);
                intent.putExtra("jml", jumlahbimbing);
                intent.putExtra("id", getIntent().getStringExtra("id"));
                intent.putExtra("nama", getIntent().getStringExtra("nama"));
                intent.putExtra("hp", getIntent().getStringExtra("hp"));
                intent.putExtra("prodi", getIntent().getStringExtra("prodi"));
                intent.putExtra("angkatan", getIntent().getStringExtra("angkatan"));
                startActivity(intent);
            }
        });
    }

    public void RefreshList() {
        Call<GetMahasiswaId> mahasiswaCall = mApiInterface.getMahasiswaId(nim);
        mahasiswaCall.enqueue(new Callback<GetMahasiswaId>() {
            @Override
            public void onResponse(Call<GetMahasiswaId> call, Response<GetMahasiswaId> response) {
                List<Mahasiswa> listmahasiswa1 = new ArrayList<>();
                listmahasiswa1 = response.body().getListDataKontak();
                for (int i = 0;i<listmahasiswa1.size();i++){
                    jumlahbimbing = listmahasiswa1.get(i).getJumlahbimbingan();
                    Log.d("INI JUMLAH BIMBINGAN", " : " + jumlahbimbing);
                }
            }

            @Override
            public void onFailure(Call<GetMahasiswaId> call, Throwable t) {
                Log.e("Gagal Bos :", t.toString());
            }
        });

        Call<GetCatatan> catatanCall = mApiInterface.getCatatan(nim);
        catatanCall.enqueue(new Callback<GetCatatan>() {
            @Override
            public void onResponse(Call<GetCatatan> call, Response<GetCatatan> response) {
                List<Catatan> listmahasiswa = new ArrayList<>();
                listmahasiswa = response.body().getListDataKontak();
                mAdapter = new CatatanAdapter(listmahasiswa);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetCatatan> call, Throwable t) {
                Log.e("Gagal Bos :", t.toString());
            }
        });
    }
}