package com.example.intentmenuapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button d, w, s;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        d = findViewById(R.id.d);
        w = findViewById(R.id.w);
        s = findViewById(R.id.s);

        d.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
            startActivity(i);
        });

        w.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(i);
        });

        s.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:1234567890"));
            i.putExtra("sms_body", "Hello! This is a test message.");
            try {
                startActivity(i);
            } catch (Exception e) {
                Toast.makeText(this, "No SMS app found!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
