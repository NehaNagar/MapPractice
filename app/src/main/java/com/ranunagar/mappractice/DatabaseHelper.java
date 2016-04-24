package com.ranunagar.mappractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nehan_000 on 19-04-2016.
 */
    public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "addContact.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_UD = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_CONTACT = "contact";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null ," +
            "name text not null, address text not null , contact text not null);";

    public DatabaseHelper(Context context)

    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(Contacts c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_UD,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_ADDRESS,c.getAddress());
        values.put(COLUMN_CONTACT,c.getContact());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String searchAdd()
    {
        db = this.getReadableDatabase() ;
        String query = "select address from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a = "";
        if(cursor.moveToFirst()) {
            a = cursor.getString(0);

        }
        return a;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
