# Week 6 (Registration and Login App)

**Aim:** Register a user and verify login credentials using a local SQLite database.

## Files
- `activity_main.xml` — registration form.
- `activity_login.xml` — sign-in form.
- `activity_home.xml` — simple destination screen after successful registration or login.
- `MainActivity.java` — validates the registration form and stores new users.
- `LoginActivity.java` — checks a username and password.
- `DBHelper.java` — creates and queries the SQLite `users` table.
- `HomeActivity.java` — opens the welcome screen.
- `AndroidManifest.xml` — registers all three activities.
- `Output/` — registration and success screenshots from the lab manual.

**Package:** `com.example.loginsqlite`

**Note:** The manual references `HomeActivity` but does not provide its Java/XML code. A minimal HomeActivity and layout are included so the navigation target exists. This is a classroom example; do not store real user passwords as plain text in a production app.
