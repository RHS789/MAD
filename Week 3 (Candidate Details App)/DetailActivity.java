package com.example.nameapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_detail);

        TextView tv = findViewById(R.id.tv);
        Button b = findViewById(R.id.b);
        tv.setText(getIntent().getStringExtra("details"));
        b.setOnClickListener(v -> finish());
    }
}
