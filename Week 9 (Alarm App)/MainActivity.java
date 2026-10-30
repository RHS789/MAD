package com.example.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private AlarmManager am;
    private Calendar cal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        Button b = findViewById(R.id.b);
        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        b.setOnClickListener(v -> {
            int h = cal.get(Calendar.HOUR_OF_DAY);
            int m = cal.get(Calendar.MINUTE);

            TimePickerDialog dlg = new TimePickerDialog(this, (tp, sh, sm) -> {
                cal.set(Calendar.HOUR_OF_DAY, sh);
                cal.set(Calendar.MINUTE, sm);
                cal.set(Calendar.SECOND, 0);

                Intent i = new Intent(this, AlarmReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(this, 0, i,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);

                tv.setText("Alarm set for: " + sh + ":" + String.format("%02d", sm));
                Toast.makeText(this, "Alarm Scheduled", Toast.LENGTH_SHORT).show();
            }, h, m, true);
            dlg.show();
        });
    }
}
