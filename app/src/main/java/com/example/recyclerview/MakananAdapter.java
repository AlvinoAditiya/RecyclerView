package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananMyViewHolder> {

    // ArrayList data yang akan kita olah di adapter
    ArrayList<ModelMakanan> listModelMakanan;

    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ModelMakanan modelMakanan);
    }

    // Konstruktor untuk mengisikan data dari activity, untuk komunikasi dari activity menuju ke adapter
    public MakananAdapter(ArrayList<ModelMakanan> listModelMakanan, OnItemClickListener listener1) {
        this.listModelMakanan = listModelMakanan;
        this.listener = listener1;
    }

    @NonNull
    @Override
    public MakananAdapter.MakananMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MakananMyViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(@NonNull MakananMyViewHolder holder, int position) {
        ModelMakanan makananModel = this.listModelMakanan.get(position);
        //dijalankan/memasang data satu per satu
        holder.tvnamamakanan.setText(makananModel.getNamaMakanan());
        holder.tvhargamakanan.setText(makananModel.getHargaMakanan());
        holder.ivGambarMakanan.setImageResource(makananModel.getGambarMakanan());

        // add action per item
        holder.itemView.setOnClickListener(v -> listener.onItemClick(makananModel));
    }

    @Override
    public int getItemCount() {
        //menghitung jumlah data berapa
        return this.listModelMakanan.size();

    }

    public static class MakananMyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnamamakanan;
        TextView tvhargamakanan;
        ImageView ivGambarMakanan;


        public MakananMyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnamamakanan = itemView.findViewById(R.id.tvnamamakanan);
            tvhargamakanan = itemView.findViewById(R.id.tvhargamakanan);
            ivGambarMakanan = itemView.findViewById(R.id.ivGambarMakanan);

        }
    }
}