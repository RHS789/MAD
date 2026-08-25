import android.os.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity{
 EditText a,b,c;
 TextView d;

 public void onCreate(Bundle x){
  super.onCreate(x);
  setContentView(R.layout.activity_main);
  a=findViewById(R.id.a);
  b=findViewById(R.id.b);
  c=findViewById(R.id.c);
  d=findViewById(R.id.d);

  findViewById(R.id.e).setOnClickListener(v->
   d.setText("Name: "+a.getText()+"\nContact: "+b.getText()+"\nCity: "+c.getText()));
 }
}
