package com.learnandroid.loginsqlite; 
import androidx.appcompat.app.AppCompatActivity; 
import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.Toast; 
public class LoginActivity extends AppCompatActivity { 
    EditText u, p; 
    Button b; 
    DBHelper db; 
    @Override 
    protected void onCreate(Bundle bd) { super.onCreate(bd); 
        setContentView(R.layout.activity_login); 
        u = (EditText) findViewById(R.id.u1); p = (EditText) findViewById(R.id.p1); b = (Button) findViewById(R.id.b); db = new DBHelper(this); 
        b.setOnClickListener(new View.OnClickListener() { @Override 
            public void onClick(View v) { 
                String us = u.getText().toString(); String pw = p.getText().toString(); 
                if(us.equals("")||pw.equals("")) 
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show(); 
                else{ 
                    Boolean ok = db.chkLogin(us, pw); 
                    if(ok==true){ 
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show(); 
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class); 
                        startActivity(i); 
                    }else{ 
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show(); 
                    } 
                } 
            } 
        }); 
    } 
} 
