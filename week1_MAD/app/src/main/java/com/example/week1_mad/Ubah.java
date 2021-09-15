package com.example.week1_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import Model.Orang;

public class Ubah extends AppCompatActivity {
    private TextInputLayout ubah_nama,ubah_umur,ubah_alamat;
    private String knama, kumur, kalamat;
    private Button buttonUbah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);
        initView();
        settext();
    }
    private void initView() {
        ubah_nama=findViewById(R.id.ubah_nama);
        ubah_umur=findViewById(R.id.ubah_umur);
        ubah_alamat=findViewById(R.id.ubah_alamat);
        buttonUbah=findViewById(R.id.buttonUbah);
    }
    private void settext(){

        Intent dapat = getIntent();
        Orang orang=Recyclerview.dataOrang.get(dapat.getIntExtra("pos",0));
        knama=orang.getNama();
        kumur=orang.getUmur();
        kalamat=orang.getAlamat();

        ubah_nama.getEditText().setText(knama);
        ubah_umur.getEditText().setText(kumur);
        ubah_alamat.getEditText().setText(kalamat);

        buttonUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orang.setNama(ubah_nama.getEditText().getText().toString().trim());
                orang.setUmur(ubah_umur.getEditText().getText().toString().trim());
                orang.setAlamat(ubah_alamat.getEditText().getText().toString().trim());

                Intent intent= new Intent (getApplicationContext(),Recyclerview.class);
                intent.putExtra("pos",getIntent().getIntExtra("pos",0));
                startActivity(intent);
            }
        });

    }
}