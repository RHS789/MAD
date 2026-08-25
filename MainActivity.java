import android.os.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity{
 EditText a,b;
 TextView r;

 public void onCreate(Bundle x){
  super.onCreate(x);
  setContentView(R.layout.activity_main);
  a=findViewById(R.id.a);
  b=findViewById(R.id.b);
  r=findViewById(R.id.r);

  findViewById(R.id.p).setOnClickListener(v->cal('+'));
  findViewById(R.id.m).setOnClickListener(v->cal('-'));
  findViewById(R.id.q).setOnClickListener(v->cal('*'));
  findViewById(R.id.d).setOnClickListener(v->cal('/'));
 }

 void cal(char o){
  if(a.getText().length()==0||b.getText().length()==0){
   r.setText("Please enter both numbers");return;
  }
  double x=Double.parseDouble(a.getText().toString());
  double y=Double.parseDouble(b.getText().toString());
  if(o=='/'&&y==0){r.setText("Cannot divide by zero");return;}
  double z=o=='+'?x+y:o=='-'?x-y:o=='*'?x*y:x/y;
  r.setText("Result: "+z);
 }
}
