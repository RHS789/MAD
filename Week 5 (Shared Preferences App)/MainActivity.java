package com.example.sharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText n, a, g;
    TextView tv;
    SharedPreferences sp;
    static final String PN = "UserInfo";

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.n);
        a = findViewById(R.id.a);
        g = findViewById(R.id.g);
        tv = findViewById(R.id.tv);
        Button b = findViewById(R.id.b);
        sp = getSharedPreferences(PN, MODE_PRIVATE);

        load();
        b.setOnClickListener(v -> save());
    }

    private void save() {
        String nm = n.getText().toString();
        String ag = a.getText().toString();
        String gen = g.getText().toString();

        sp.edit().putString("Name", nm)
                .putString("Age", ag)
                .putString("Gender", gen)
                .apply();
        tv.setText("Saved: " + nm + ", " + ag + ", " + gen);
    }

    private void load() {
        String nm = sp.getString("Name", "Not set");
        String ag = sp.getString("Age", "Not set");
        String gen = sp.getString("Gender", "Not set");
        tv.setText("Loaded: " + nm + ", " + ag + ", " + gen);

    }
}
