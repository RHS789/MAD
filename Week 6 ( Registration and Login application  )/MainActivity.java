package com.learnandroid.loginsqlite; 
import androidx.appcompat.app.AppCompatActivity; import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; import android.widget.EditText; import android.widget.Toast; 
public class MainActivity extends AppCompatActivity { 
    EditText u, p, rp; 
    Button su, si; 
    DBHelper db; 
    @Override 
    protected void onCreate(Bundle bd) { super.onCreate(bd); 
        setContentView(R.layout.activity_main); 
        u = (EditText) findViewById(R.id.u); 
        p = (EditText) findViewById(R.id.p); 
        rp = (EditText) findViewById(R.id.rp); su = (Button) findViewById(R.id.su); 
        si = (Button) findViewById(R.id.si); 
        db = new DBHelper(this); 
        su.setOnClickListener(new View.OnClickListener() { @Override 
            public void onClick(View v) { 
                String us = u.getText().toString(); 
                String pw = p.getText().toString(); 
                String rpw = rp.getText().toString(); 
                if(us.equals("")||pw.equals("")||rpw.equals("")) Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show(); 
                else{ 
                    if(pw.equals(rpw)){ 
                        Boolean cu = db.chkU(us); 
                        if(cu==false){ 
                            Boolean ins = db.ins(us, pw); 
                            if(ins==true){ 
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show(); 
                                Intent i = new Intent(getApplicationContext(),HomeActivity.class); 
                                startActivity(i); 
                            }else{ 
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show(); 
                            } 
                        } 
                        else{ 
                            Toast.makeText(MainActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show(); 
                        } 
                    }else{ 
                        Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show(); 
                    } 
                } } 
        }); 
        si.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                Intent i = new Intent(getApplicationContext(), LoginActivity.class); 
                startActivity(i); 
            } 
        }); 
    } 
} 
