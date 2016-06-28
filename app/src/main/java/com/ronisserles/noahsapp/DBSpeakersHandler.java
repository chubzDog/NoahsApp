package com.ronisserles.noahsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Tardis on 6/21/16.
 */
public class DBSpeakersHandler {

    private DBSpeakersHelper database;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor cursor;

    public DBSpeakersHandler(Context context){
        database = new DBSpeakersHelper(context,Const.DB_SPEAKERS_NAME,null,1);
    }

//    public void addSpeaker(Speaker speaker){
//        db = database.getWritableDatabase();
//        try {
//            cv = new ContentValues();
//            //scv.p
//        }
//        catch (){
//
//        }
//        finally {
//
//        }
//    }
}
