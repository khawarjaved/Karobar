package com.khawarjk.karobar;

/**
 * Created by khawarjk on 18/5/2020.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c) {
        this.context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String title, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.TITLE_COLUMN, title);
        contentValues.put(dbHelper.DESCRIPTION_COLUMN, description);
        database.insert(dbHelper.TABLE_NAME, null, contentValues);
    }

    public void update(int id, String title, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.TITLE_COLUMN, title);
        contentValues.put(dbHelper.DESCRIPTION_COLUMN, description);
        database.update(dbHelper.TABLE_NAME, contentValues, dbHelper.ID_COLUMN + " = " + id, null);
    }

    public void delete(int id) {
        database.delete(dbHelper.TABLE_NAME,dbHelper.ID_COLUMN + " ='" + id + "'",null);
    }

    public Cursor fetch() {
        String[] columns = new String[]{dbHelper.ID_COLUMN, dbHelper.TITLE_COLUMN, dbHelper.DESCRIPTION_COLUMN, dbHelper.TIMESTAMP_COLUMN};
        Cursor cursor = database.query(dbHelper.TABLE_NAME, columns, null, null, null, null, "Timestamp DESC");
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
