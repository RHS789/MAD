import android.os.*;
import android.content.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity{
 EditText a,b,c;
 TextView d;
 SharedPreferences p;

 public void onCreate(Bundle x){
  super.onCreate(x);
  setContentView(R.layout.activity_main);

  a=findViewById(R.id.a);
  b=findViewById(R.id.b);
  c=findViewById(R.id.c);
  d=findViewById(R.id.d);
  p=getSharedPreferences("U",0);

  load();
  findViewById(R.id.s).setOnClickListener(v->save());
 }

 void save(){
  String x=a.getText().toString(),y=b.getText().toString(),z=c.getText().toString();
  p.edit().putString("n",x).putString("a",y).putString("g",z).apply();
  d.setText("Saved: "+x+", "+y+", "+z);
 }

 void load(){
  d.setText("Loaded: "+p.getString("n","Not set")+", "+
   p.getString("a","Not set")+", "+p.getString("g","Not set"));
 }
}
