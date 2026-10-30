package com.example.openurlapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        b = findViewById(R.id.b);

        b.setOnClickListener(v -> {
            String u = et.getText().toString().trim();
            if (u.isEmpty()) {
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!u.startsWith("http://") && !u.startsWith("https://")) {
                u = "https://" + u;
            }

            try {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(u));
                startActivity(i);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "No browser app found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
