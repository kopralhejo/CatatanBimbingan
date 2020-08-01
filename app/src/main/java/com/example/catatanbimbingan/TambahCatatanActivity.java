package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TambahCatatanActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3,  text5;
    TextView text4;
    String nim;
    Integer bimbing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (TextView) findViewById(R.id.textView1);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Mahasiswa WHERE nim = '" +
                getIntent().getStringExtra("nim") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            nim = cursor.getString(1).toString();
        }

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                nim = getIntent().getStringExtra("nim");
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into Catatan(judul,catatan,nim) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        nim + "')");

                cursor = db.rawQuery("SELECT * FROM Catatan WHERE nim = '" +
                        getIntent().getStringExtra("nim") + "'",null);
                cursor.moveToFirst();
                if (cursor.getCount()>0)
                {
                    cursor.moveToPosition(0);
                    if (cursor.getInt(3) == Integer.parseInt(null)){
                        db.execSQL("update Catatan set bimbingan = 1");
                    } else {
                        db.execSQL("update Catatan set bimbingan = '"+ cursor.getInt(3) + 1 +"' where nim = '"+ cursor.getString(1).toString());
                    }
                    nim = cursor.getString(1).toString();
                }
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
//                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}