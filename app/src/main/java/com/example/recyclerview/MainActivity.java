package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MakananAdapter.OnItemClickListener{

    RecyclerView rvlistmakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        rvlistmakanan = (RecyclerView) findViewById(R.id.rvlistmakanan);
        rvlistmakanan.setLayoutManager(new LinearLayoutManager(this));


        // Deklarasi dan inisialisasi List
        ArrayList<ModelMakanan> listMakanan = new ArrayList<>();

        listMakanan.add(new ModelMakanan("Sate Ayam","Rp.10.000", R.drawable.sate));
        listMakanan.add(new ModelMakanan("Bakso","Rp10.000" ,R.drawable.bakso));
        listMakanan.add(new ModelMakanan("Mie Goreng","Rp7.000", R.drawable.migoreng));
        listMakanan.add(new ModelMakanan("Es Buah","Rp10.000", R.drawable.esbuah));
        listMakanan.add(new ModelMakanan("Ayam bakar","Rp20.000", R.drawable.ayambakar));
        listMakanan.add(new ModelMakanan("Mie ayam","Rp8.000", R.drawable.miayam));

        //call adapter class
        MakananAdapter adaptermakanan = new MakananAdapter(listMakanan, this);
        rvlistmakanan.setAdapter(adaptermakanan);

    }

    @Override
    public void onItemClick(ModelMakanan modelMakanan) {
        Toast.makeText(this, modelMakanan.getNamaMakanan() + ","+ modelMakanan.getHargaMakanan(), Toast.LENGTH_SHORT).show();
        // dari main activity menuju ke detail
        Intent in = new Intent(MainActivity.this, DetailMakanan.class);
        // memberikan data / melempar
        in.putExtra("namaMakanan", modelMakanan.getNamaMakanan());
        in.putExtra("gambarMakanan", modelMakanan.getGambarMakanan());
        startActivity(in);
    }
}