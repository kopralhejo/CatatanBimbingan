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

import com.example.catatanbimbingan.Sql.DataHelper;

public class TambahCatatanActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3,  text5;
    TextView text4, textv1;
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
//        text4 = (TextView) findViewById(R.id.textView1);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        textv1 = (TextView) findViewById(R.id.textView1);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                nim = getIntent().getStringExtra("nim");
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM Catatan WHERE nim = '" +
                        getIntent().getStringExtra("nim") + "'ORDER BY bimbingan DESC LIMIT 1 ",null);
                cursor.moveToFirst();
                if (cursor.getCount()==0)
                {
                    cursor.moveToPosition(0);
                        SQLiteDatabase db1 = dbHelper.getWritableDatabase();
                        db1.execSQL("insert into Catatan(judul,catatan,nim,bimbingan) values('" +
                                text1.getText().toString() + "','" +
                                text2.getText().toString() + "','" +
                                nim + "'," +
                                "1)");
//                        db.execSQL("update Catatan set bimbingan = '"+ 1 +"' where nim = '"+ cursor.getString(2).toString() + "'");
                } else {
                    Integer jml = cursor.getInt(3) + 1;
                    SQLiteDatabase db1 = dbHelper.getWritableDatabase();
                    db1.execSQL("insert into Catatan(judul,catatan,nim,bimbingan) values('" +
                            text1.getText().toString() + "','" +
                            text2.getText().toString() + "','" +
                            nim                        + "','" +
                            jml +"')");
//                        db.execSQL("update Catatan set bimbingan = '"+ jml +"' where nim = '"+ cursor.getString(2).toString() + "'");
                }
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                ListCatatanActivity.ma.RefreshList();
                finish();
            }
        });
    }
}