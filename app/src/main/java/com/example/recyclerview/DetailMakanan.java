package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailMakanan extends AppCompatActivity {

    TextView tvNamaMakananDetail;
    ImageView ivGambarMakananDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_makanan);

        tvNamaMakananDetail = findViewById(R.id.tvNamaMakananDetail);
        ivGambarMakananDetail = findViewById(R.id.ivGambarMakananDetail);
        //kta menangkap data dari inetnt
        Intent intent = getIntent();
        String namaMakanan = intent.getStringExtra("namaMakanan");
        int gambarMakanan = getIntent().getIntExtra("gambarMakanan", 0);

        tvNamaMakananDetail.setText(namaMakanan);
        ivGambarMakananDetail.setImageResource(gambarMakanan);



    }
}