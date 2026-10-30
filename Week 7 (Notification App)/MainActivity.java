package com.example.notify;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CID = "10001";

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.b);

        if (Build.VERSION.SDK_INT >= 33 &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }

        b.setOnClickListener(v -> {
            NotificationManager nm =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel nc = new NotificationChannel(
                        CID, "My Notifications", NotificationManager.IMPORTANCE_HIGH);
                nm.createNotificationChannel(nc);
            }

            NotificationCompat.Builder nb = new NotificationCompat.Builder(this, CID)
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle("Test")
                    .setContentText("Hello! This is my first push notification")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);

            nm.notify(1, nb.build());
            Toast.makeText(this, "Notification created: Test - Hello! This is my first push notification", Toast.LENGTH_LONG).show();
        });
    }
}
