import android.os.*;
import android.content.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity{
 String[] n={"Alice","Bob","Charlie","David"};
 String[] d={"Alice - Android Developer from NYC",
 "Bob - Data Scientist from LA",
 "Charlie - UX Designer from Chicago",
 "David - QA Engineer from Seattle"};

 public void onCreate(Bundle b){
  super.onCreate(b);
  setContentView(R.layout.activity_main);
  ListView l=findViewById(R.id.l);
  l.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,n));
  l.setOnItemClickListener((a,v,p,i)->
   startActivity(new Intent(this,DetailActivity.class).putExtra("d",d[p])));
 }
}
