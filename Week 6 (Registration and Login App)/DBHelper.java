package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DBN = "Login.db";

    public DBHelper(Context c) {
        super(c, DBN, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean ins(String u, String p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", u);
        cv.put("password", p);
        return db.insert("users", null, cv) != -1;
    }

    public boolean chkU(String u) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{u});
        boolean ok = c.getCount() > 0;
        c.close();
        return ok;
    }

    public boolean chkLogin(String u, String p) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?",
                new String[]{u, p});
        boolean ok = c.getCount() > 0;
        c.close();
        return ok;
    }
}
