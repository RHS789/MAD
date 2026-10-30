# Week 11 (GPS Location App)

**Aim:** Request location permission and display the device's GPS latitude and longitude.

## Files
- `activity_main.xml` — Get Location button and location text.
- `MainActivity.java` — asks for location permission, receives one GPS update, and displays latitude/longitude.
- `AndroidManifest.xml` — declares fine and coarse location permissions.
- `Output/` — location app screenshots from the lab manual.

Create an Android Java project with package `com.example.gpslocationapp` and copy the files into the matching project locations. Enable GPS/location on the device and grant permission. The example uses the GPS provider and stops updates after the first fix.
