package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catatanbimbingan.RestApi.ApiClient;
import com.example.catatanbimbingan.RestApi.ApiInterface;
import com.example.catatanbimbingan.RestApi.PostPutDelCatatan;
import com.example.catatanbimbingan.RestApi.PostPutDelCatatan;
import com.example.catatanbimbingan.RestApi.PostPutDelMahasiswa;
import com.example.catatanbimbingan.Sql.DataHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahCatatanActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3,  text5;
    TextView text4, textv1;
    String tanggal;
    Integer bimbing;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        Date dNow = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat ("hh:mm dd-MM-yyyy");
        tanggal = ft.format(dNow);
        dbHelper = new DataHelper(this);
//        tanggal = String.valueOf(new Date());
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
//        text4 = (TextView) findViewById(R.id.textView1);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        textv1 = (TextView) findViewById(R.id.textView1);
        final Intent mIntent = getIntent();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Log.d("Retrofit Get", "lempar tanggal " +
                String.valueOf(mIntent.getStringExtra("jml")));
        if (mIntent.getStringExtra("jml")==null){
            bimbing = 0;
        } else {
            bimbing = mIntent.getIntExtra("jml",0);
        };
        Log.d("Jumlah Bimbingan", "lempar tanggal " +
                String.valueOf(mIntent.getStringExtra("id")));


        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bimbing = bimbing + 1;
                Call<PostPutDelCatatan> postPutDelCatatanCall = mApiInterface.PostCatatan(
                        text1.getText().toString(),
                        bimbing,
                        text2.getText().toString(),
                        tanggal,
                        mIntent.getStringExtra("nim"));
                postPutDelCatatanCall.enqueue(new Callback<PostPutDelCatatan>() {
                    @Override
                    public void onResponse(Call<PostPutDelCatatan> call, Response<PostPutDelCatatan> response) {

                        Call<PostPutDelMahasiswa> postPutDelMahasiswaCall = mApiInterface.PutMahasiswa(
                                mIntent.getStringExtra("id"),
                                mIntent.getStringExtra("nim"),
                                getIntent().getStringExtra("nama"),
                                getIntent().getStringExtra("hp"),
                                getIntent().getStringExtra("prodi"),
                                getIntent().getStringExtra("angkatan"),
                                Integer.toString(bimbing),
                                tanggal
                        );
                        postPutDelMahasiswaCall.enqueue(new Callback<PostPutDelMahasiswa>() {
                            @Override
                            public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                                Log.d("D1 BERHASIL", "MANTAB" );
                            }

                            @Override
                            public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                Log.d("D1 BERHASIL", "TIDAK MANTAB" );
                            }
                        });
                        ListCatatanActivity.ma.RefreshList();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelCatatan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
//                tanggal = getIntent().getStringExtra("tanggal");
//                SQLiteDatabase db = dbHelper.getReadableDatabase();
//                cursor = db.rawQuery("SELECT * FROM Catatan WHERE tanggal = '" +
//                        getIntent().getStringExtra("tanggal") + "'ORDER BY bimbingan DESC LIMIT 1 ",null);
//                cursor.moveToFirst();
//                if (cursor.getCount()==0)
//                {
//                    cursor.moveToPosition(0);
//                        SQLiteDatabase db1 = dbHelper.getWritableDatabase();
//                        db1.execSQL("insert into Catatan(judul,catatan,tanggal,bimbingan) values('" +
//                                text1.getText().toString() + "','" +
//                                text2.getText().toString() + "','" +
//                                tanggal + "'," +
//                                "1)");
////                        db.execSQL("update Catatan set bimbingan = '"+ 1 +"' where tanggal = '"+ cursor.getString(2).toString() + "'");
//                } else {
//                    Integer jml = cursor.getInt(3) + 1;
//                    SQLiteDatabase db1 = dbHelper.getWritableDatabase();
//                    db1.execSQL("insert into Catatan(judul,catatan,tanggal,bimbingan) values('" +
//                            text1.getText().toString() + "','" +
//                            text2.getText().toString() + "','" +
//                            tanggal                        + "','" +
//                            jml +"')");
////                        db.execSQL("update Catatan set bimbingan = '"+ jml +"' where tanggal = '"+ cursor.getString(2).toString() + "'");
//                }
//                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                ListCatatanActivity.ma.RefreshList();
                finish();
            }
        });
    }
}