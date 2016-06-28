package com.ronisserles.noahsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tardis on 6/10/16.
 */
public class DBSpeakersHelper extends SQLiteOpenHelper {

    private String DB_CREATE = "create table" + Const.TABLE_SPEAKERS + "("
            + Const.COLUMN_ID + "INTEGER PRIMARY KEY,"
            + Const.COLUMN_NAME + "TEXT,"
            + Const.COLUMN_AGE + "REAL,"
            + Const.COLUMN_IMG + "TEXT);";

    public DBSpeakersHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DB_CREATE);
        }
        catch (SQLiteException e){
            e.getCause();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
