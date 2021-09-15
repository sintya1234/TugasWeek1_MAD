package com.example.week1_mad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Model.Orang;

public class Recyclerview extends AppCompatActivity {
    private RecyclerView recyclerView_ku;
    public static ArrayList<Orang> dataOrang=new ArrayList<Orang>();
    public static OrangRVadapter adapter;
    private FloatingActionButton floatingActionButton;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initView();
        setupRecyclerView();
        setListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 200) {
                Orang inputdata= data.getParcelableExtra("OrangBaru");
                dataOrang.add(inputdata);
                adapter.notifyDataSetChanged();
            }
        }
    }
    private void initView() {
        recyclerView_ku=findViewById(R.id.recyclerView_ku);
        adapter= new OrangRVadapter (dataOrang,getApplicationContext());
        floatingActionButton=findViewById(R.id.floatingActionButton);
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getBaseContext());
        recyclerView_ku.setLayoutManager(manager);
        recyclerView_ku.setAdapter(adapter);
    }

    private void setListener() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (getBaseContext(), InputOrang.class);
                startActivityForResult(intent,1);
            }
        });
    }




}