package com.example.userinputapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText n, ph, ct;
    TextView tv;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.n);
        ph = findViewById(R.id.ph);
        ct = findViewById(R.id.ct);
        tv = findViewById(R.id.tv);
        Button b = findViewById(R.id.b);

        b.setOnClickListener(v -> {
            String nm = n.getText().toString().trim();
            String con = ph.getText().toString().trim();
            String city = ct.getText().toString().trim();
            tv.setText("Name: " + nm + "\nContact: " + con + "\nCity: " + city);
        });
    }
}
