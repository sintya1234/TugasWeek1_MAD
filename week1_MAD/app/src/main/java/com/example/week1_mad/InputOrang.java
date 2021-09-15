package com.example.week1_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import Model.Orang;

public class InputOrang extends AppCompatActivity {

    private TextInputLayout textInputLayout_nama,textInputLayout_alamat,textInputLayout_umur;
    private Button button_simpan;
   // final loading_dialog loadingDialog=new loading_dialog (InputOrang.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_orang);
        initView();
        setListener();
    }

    private void initView() {
        textInputLayout_nama=findViewById(R.id.textInputLayout_nama);
        textInputLayout_umur=findViewById(R.id.textInputLayout_umur);
        textInputLayout_alamat=findViewById(R.id.textInputLayout_alamat);
        button_simpan=findViewById(R.id.button_simpan);
    }

    private void setListener() {

        textInputLayout_nama.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nama = textInputLayout_nama.getEditText().getText().toString().trim();

                button_simpan.setEnabled(!nama.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textInputLayout_umur.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String umur=textInputLayout_umur.getEditText().getText().toString().trim();
                if(umur.isEmpty()){
                    button_simpan.setEnabled(false);
                }else{
                    button_simpan.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textInputLayout_alamat.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String alamat=textInputLayout_alamat.getEditText().getText().toString().trim();
                if(alamat.isEmpty()){
                    button_simpan.setEnabled(false);
                }else{
                    button_simpan.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //    loadingDialog.start_loading();
              //  Handler handler=new Handler();
                //handler.postDelayed(new Runnable() {
                  //  @Override
                    //public void run() {
                      //  loadingDialog.dismissDialog();
                    //}
                //}, 5000);

                String nama = textInputLayout_nama.getEditText().getText().toString().trim();
                String umur=textInputLayout_umur.getEditText().getText().toString().trim();
                String alamat=textInputLayout_alamat.getEditText().getText().toString().trim();

                Orang temp=new Orang(nama,umur,alamat);
                Intent intent = new Intent();
                intent.putExtra("OrangBaru", temp);
                setResult(200, intent);
                finish();
            }
        });
    }
}