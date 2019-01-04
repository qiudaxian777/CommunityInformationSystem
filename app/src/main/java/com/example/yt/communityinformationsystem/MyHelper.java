package com.example.yt.communityinformationsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
public MyHelper(Context context) {
        super(context, "itcast.db",null ,1);
        }

@Override
public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),id VARCHAR(20))");
        }

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
        }
