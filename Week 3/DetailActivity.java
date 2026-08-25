import android.os.*;
import android.widget.*;
import androidx.appcompat.app.*;

public class DetailActivity extends AppCompatActivity{
 public void onCreate(Bundle b){
  super.onCreate(b);
  setContentView(R.layout.activity_detail);
  ((TextView)findViewById(R.id.t)).setText(getIntent().getStringExtra("d"));
  findViewById(R.id.b).setOnClickListener(v->finish());
 }
}
