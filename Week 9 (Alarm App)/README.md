# Week 9 (Alarm App)

**Aim:** Select an alarm time with `TimePickerDialog` and schedule it with `AlarmManager`.

## Files
- `activity_main.xml` — Set Alarm Time button and selected-time label.
- `MainActivity.java` — displays the time picker and schedules the alarm.
- `AlarmReceiver.java` — receives the alarm and displays a Toast.
- `AndroidManifest.xml` — declares the receiver.
- `Output/` — alarm screen and time-picker screenshots from the lab manual.

Create an Android Java project with package `com.example.alarmapp`. Copy each file into the matching project location. The alarm uses `AlarmManager.set()` and may be delayed by Android power-saving behavior.
