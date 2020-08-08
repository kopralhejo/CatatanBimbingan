package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
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

public class TambahMahasiswaActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mahasiswa);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Call<PostPutDelMahasiswa> postKontakCall = mApiInterface.PostMahasiswa(
                        text1.getText().toString(),
                        text2.getText().toString(),
                        text3.getText().toString(),
                        text4.getText().toString(),
                        text5.getText().toString(),
                        null,
                        null);
                postKontakCall.enqueue(new Callback<PostPutDelMahasiswa>() {
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
//                // TODO Auto-generated method stub
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.execSQL("insert into Mahasiswa(nim,nama,hp,prodi,angkatan) values('" +
//                        text1.getText().toString() + "','" +
//                        text2.getText().toString() + "','" +
//                        text3.getText().toString() + "','" +
//                        text4.getText().toString() + "','" +
//                        text5.getText().toString() + "')");
//                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
//                MainActivity.ma.RefreshList();
//                finish();
//            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}