package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catatanbimbingan.RestApi.ApiClient;
import com.example.catatanbimbingan.RestApi.ApiInterface;
import com.example.catatanbimbingan.RestApi.PostPutDelMahasiswa;
import com.example.catatanbimbingan.Sql.DataHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMahasiswaActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2, ton3;
    EditText text1, text2, text3, text4, text5;
    ApiInterface mApiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mahasiswa);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);

        final Intent mIntent = getIntent();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Log.d("Retrofit Get", "id : " +
                String.valueOf(mIntent.getStringExtra("id")));
        text1.setText(mIntent.getStringExtra("nim"));
        text2.setText(mIntent.getStringExtra("nama"));
        text3.setText(mIntent.getStringExtra("hp"));
        text4.setText(mIntent.getStringExtra("prodi"));
        text5.setText(mIntent.getStringExtra("angkatan"));

        Log.e("ID ::", "hello"+mIntent.getStringExtra("Id"));
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton3 = (Button) findViewById(R.id.button3);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMahasiswa> updateKontakCall = mApiInterface.PutMahasiswa(
                        mIntent.getStringExtra("id"),
                        text1.getText().toString(),
                        text2.getText().toString(),
                        text3.getText().toString(),
                        text4.getText().toString(),
                        text5.getText().toString(),
                        mIntent.getStringExtra("jml"),
                        null);
                updateKontakCall.enqueue(new Callback<PostPutDelMahasiswa>() {
                    @Override
                    public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                        MainActivity.ma.RefreshList();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        ton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Call<PostPutDelMahasiswa> delMahasiswaCall = mApiInterface.deleteMahasiswa(mIntent.getStringExtra("id"));
                delMahasiswaCall.enqueue(new Callback<PostPutDelMahasiswa>() {
                    @Override
                    public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                        Log.d("Proses Hapus Berhasil", "Caution : " +
                                String.valueOf(response.body()));
                        MainActivity.ma.RefreshList();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                        Log.d("Proses Hapus Berhasil", "Caution : "+t.toString());
                    }
                });
            }
        });
    }
}