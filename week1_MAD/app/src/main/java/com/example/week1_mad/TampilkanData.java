package com.example.week1_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import Model.Orang;

public class TampilkanData extends AppCompatActivity {
    private String snama, sumur, salamat;
    private TextView TV_nama,TV_umur,TV_alamat;
    private Button TD_btn_ubah;
    private ImageView image_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_data);

        Intent dapat = getIntent();
        snama=dapat.getStringExtra("snama");
        sumur=dapat.getStringExtra("sumur");
        salamat=dapat.getStringExtra("salamat");

        TV_nama=findViewById(R.id.TV_nama);
        TV_umur=findViewById(R.id.TV_umur);
        TV_alamat=findViewById(R.id.TV_alamat);
        image_delete=findViewById(R.id.image_delete);
        TD_btn_ubah=findViewById(R.id.TD_btn_ubah);

        TV_nama.setText(snama);
        TV_umur.setText(sumur);
        TV_alamat.setText(salamat);

        image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Recyclerview.dataOrang.remove(getIntent().getIntExtra("pos",0));
                Intent intent= new Intent (getApplicationContext(), Recyclerview.class);
                startActivity(intent);
            }
        });

        TD_btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (getApplicationContext(),Ubah.class);
                intent.putExtra("pos",getIntent().getIntExtra("pos",0));
                startActivity(intent);
            }
        });
    }

}