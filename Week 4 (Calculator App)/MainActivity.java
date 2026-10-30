package com.example.calculatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    TextView tv;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        tv = findViewById(R.id.tv);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);

        b1.setOnClickListener(v -> calc('+'));
        b2.setOnClickListener(v -> calc('-'));
        b3.setOnClickListener(v -> calc('*'));
        b4.setOnClickListener(v -> calc('/'));
    }

    private void calc(char op) {
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        if (s1.isEmpty() || s2.isEmpty()) {
            tv.setText("Please enter both numbers");
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double res;

        switch (op) {
            case '+': res = n1 + n2; break;
            case '-': res = n1 - n2; break;
            case '*': res = n1 * n2; break;
            case '/':
                if (n2 == 0) {
                    tv.setText("Cannot divide by zero");
                    return;
                }
                res = n1 / n2;
                break;
            default: return;
        }
        tv.setText("Result: " + res);
    }
}
