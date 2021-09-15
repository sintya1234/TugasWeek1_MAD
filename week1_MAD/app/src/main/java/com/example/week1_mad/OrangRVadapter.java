package com.example.week1_mad;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.Orang;

public class OrangRVadapter extends RecyclerView.Adapter<OrangRVadapter.BarangViewHolder>{
    private Context context;
    private ArrayList<Orang> ListOrang;
    private int pos;

    public OrangRVadapter(ArrayList<Orang>listOrang, Context context) {
    this.context=context;
        this.ListOrang = listOrang;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater LayoutInflater= android.view.LayoutInflater.from((parent.getContext()));
        View view=LayoutInflater.inflate(R.layout.card_view_orang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        holder.textView_nama.setText(String.valueOf(ListOrang.get(position).getNama()));
        holder.textView_umur.setText(String.valueOf(ListOrang.get(position).getUmur()));
        holder.textView_alamat.setText(String.valueOf(ListOrang.get(position).getAlamat()));
    }

    @Override
    public int getItemCount() {
        return ListOrang.size();
    }



    public class BarangViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_nama,textView_umur,textView_alamat;
        private ImageView imageView;

        private CardView CV_ungu;
        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_nama= itemView.findViewById(R.id.textView_nama);
            textView_umur= itemView.findViewById(R.id.textView_umur);
            textView_alamat= itemView.findViewById(R.id.textView_alamat);
            CV_ungu= itemView.findViewById(R.id.CV_ungu);

        pos=getAdapterPosition();

            CV_ungu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nama = textView_nama.getText().toString().trim();
                    String umur=textView_umur.getText().toString().trim();
                    String alamat=textView_alamat.getText().toString().trim();
                    Intent send = new Intent(context, TampilkanData.class);
                    send.putExtra("snama", nama);
                    send.putExtra("sumur", umur);
                    send.putExtra("salamat", alamat);
                    send.putExtra("position",pos);
                    send.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(send);
                }

            });
    }
}
public int position(){
        return pos;
}


}

