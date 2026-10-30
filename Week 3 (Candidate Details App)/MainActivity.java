package com.example.nameapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] nm = {"Alice", "Bob", "Charlie", "David"};
    String[] dt = {
        "Alice - Android Developer from NYC",
        "Bob - Data Scientist from LA",
        "Charlie - UX Designer from Chicago",
        "David - QA Engineer from Seattle"
    };

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, nm);
        lv.setAdapter(ad);

        lv.setOnItemClickListener((p, v, pos, id) -> {
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("details", dt[pos]);
            startActivity(i);
        });
    }
}
