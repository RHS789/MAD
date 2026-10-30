package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText u, p;
    DBHelper db;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_login);

        u = findViewById(R.id.u1);
        p = findViewById(R.id.p1);
        Button b = findViewById(R.id.b);
        db = new DBHelper(this);

        b.setOnClickListener(v -> {
            String us = u.getText().toString().trim();
            String pw = p.getText().toString();

            if (us.isEmpty() || pw.isEmpty()) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else if (db.chkLogin(us, pw)) {
                Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
