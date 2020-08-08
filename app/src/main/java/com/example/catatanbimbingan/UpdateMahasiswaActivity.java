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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMahasiswaActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
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
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM Mahasiswa WHERE nim = '" + getIntent().getStringExtra("nim") + "'",null);
//        cursor.moveToFirst();
//        if (cursor.getCount()>0)
//        {
//            cursor.moveToPosition(0);
//            text1.setText(cursor.getString(1).toString());
//            text2.setText(cursor.getString(2).toString());
//            text3.setText(cursor.getString(3).toString());
//            text4.setText(cursor.getString(4).toString());
//            text5.setText(cursor.getString(5).toString());
//        }
        Log.d("Retrofit Get", "id : " +
                String.valueOf(mIntent.getStringExtra("Id")));
        text1.setText(mIntent.getStringExtra("nim"));
        text2.setText(mIntent.getStringExtra("nama"));
        text3.setText(mIntent.getStringExtra("hp"));
        text4.setText(mIntent.getStringExtra("prodi"));
        text5.setText(mIntent.getStringExtra("angkatan"));
//        Call<GetMahasiswaId> mahasiswaCall = mApiInterface.getMahasiswaId("1");
//        mahasiswaCall.enqueue(new Callback<GetMahasiswaId>() {
//            @Override
//            public void onResponse(Call<GetMahasiswaId> call, Response<GetMahasiswaId> response) {
//                List<Mahasiswa> listmahasiswa = new ArrayList<>();
//                listmahasiswa = response.body().getListDataKontak();
//                Log.d("Retrofit Get", "Jumlah data mahasiswa: " +
//                        String.valueOf(listmahasiswa.size()));
//                mAdapter = new MahasiswaAdapter(listmahasiswa);
//                recyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<GetMahasiswaId> call, Throwable t) {
//                Log.e("Retrofit Get", t.toString());
//            }
//        });

        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.execSQL("update Mahasiswa set nim='"+ text1.getText().toString() +"', nama='" + text2.getText().toString()+"', hp='" + text3.getText().toString()+"', prodi='" + text4.getText().toString()+"', angkatan='" + text5.getText().toString()+"' where nim='" +
//                        getIntent().getStringExtra("nim") +"'");
//
//                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Call<PostPutDelMahasiswa> updateKontakCall = mApiInterface.PutMahasiswa(
                        mIntent.getStringExtra("Id"),
                        text1.getText().toString(),
                        text2.getText().toString(),
                        text3.getText().toString(),
                        text4.getText().toString(),
                        text5.getText().toString(),
                        null,
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
                MainActivity.ma.RefreshList();
                finish();
            }
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