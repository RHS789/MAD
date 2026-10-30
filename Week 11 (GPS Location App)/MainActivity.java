package com.example.gpslocationapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int PC = 100;
    private LocationManager lm;
    private TextView tv;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.b);
        tv = findViewById(R.id.tv);
        b.setOnClickListener(v -> loc());
    }

    private void loc() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PC);
        } else {
            lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
        }
    }

    private final LocationListener ll = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location loc) {
            double lat = loc.getLatitude();
            double lon = loc.getLongitude();
            tv.setText("Latitude: " + lat + "\nLongitude: " + lon);
            lm.removeUpdates(this);
        }

        @Override
        public void onStatusChanged(String p, int status, Bundle extras) { }

        @Override
        public void onProviderEnabled(@NonNull String p) { }

        @Override
        public void onProviderDisabled(@NonNull String p) {
            Toast.makeText(MainActivity.this, "Please enable GPS", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onRequestPermissionsResult(int rc, @NonNull String[] per,
                                           @NonNull int[] gr) {
        super.onRequestPermissionsResult(rc, per, gr);
        if (rc == PC) {
            if (gr.length > 0 && gr[0] == PackageManager.PERMISSION_GRANTED) {
                loc();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
