package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.catatanbimbingan.RestApi.ApiClient;
import com.example.catatanbimbingan.RestApi.ApiInterface;
import com.example.catatanbimbingan.RestApi.GetCatatan;
import com.example.catatanbimbingan.RestApi.PostPutDelCatatan;
import com.example.catatanbimbingan.Sql.DataHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditCatatanActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;
    ApiInterface mApiInterface;
    String bim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_catatan);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

            text1.setText(getIntent().getStringExtra("dul"));
            text2.setText(getIntent().getStringExtra("cat"));
        bim = String.valueOf(getIntent().getIntExtra("bim",0));
        Log.d("D1 BERHASIL", "ISI BIM "+bim);


        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Call<PostPutDelCatatan> postPutDelCatatanCall = mApiInterface.PutCatatan(
                        getIntent().getStringExtra("id"),
                        text1.getText().toString(),
                        getIntent().getStringExtra("nim"),
                        bim,
                        text2.getText().toString(),
                        getIntent().getStringExtra("tgl")
                        );

                postPutDelCatatanCall.enqueue(new Callback<PostPutDelCatatan>() {
                                                  @Override
                                                  public void onResponse(Call<PostPutDelCatatan> call, Response<PostPutDelCatatan> response) {
                                                      Log.d("D1 BERHASIL", "MANTAB" );
                                                  }

                                                  @Override
                                                  public void onFailure(Call<PostPutDelCatatan> call, Throwable t) {
                                                      Log.d("D1 GAGAL", "MANTAB" + t.toString());
                                                  }
                                              });
                ListCatatanActivity.ma.RefreshList();
                finish();
            }
        });
    }
}