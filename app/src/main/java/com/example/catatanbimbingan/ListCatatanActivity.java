package com.example.catatanbimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ListCatatanActivity extends AppCompatActivity {

    private Button btntambahmahasiswa;
    String nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_catatan);

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
}