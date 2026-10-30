package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText u, p, rp;
    DBHelper db;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        u = findViewById(R.id.u);
        p = findViewById(R.id.p);
        rp = findViewById(R.id.rp);
        Button su = findViewById(R.id.su);
        Button si = findViewById(R.id.si);
        db = new DBHelper(this);

        su.setOnClickListener(v -> {
            String us = u.getText().toString().trim();
            String pw = p.getText().toString();
            String rpw = rp.getText().toString();

            if (us.isEmpty() || pw.isEmpty() || rpw.isEmpty()) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else if (!pw.equals(rpw)) {
                Toast.makeText(this, "Passwords not matching", Toast.LENGTH_SHORT).show();
            } else if (db.chkU(us)) {
                Toast.makeText(this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
            } else if (db.ins(us, pw)) {
                Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });

        si.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
    }
}
