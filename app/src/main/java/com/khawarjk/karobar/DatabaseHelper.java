package com.khawarjk.karobar;

/**
 * Created by khawarjk on 18/5/2020.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Initialize Database Information
    private static final String DB_NAME = "Karobar.db";
    // Initialize Database version
    private static final int DB_VERSION = 1;
    // Initialize Table Name
    static final String TABLE_NAME = "Products";
    // Initialize Table from(Columns)
    static final String ID_COLUMN = "_id";
    static final String TITLE_COLUMN = "Title";
    static final String DESCRIPTION_COLUMN = "Description";
    static final String TIMESTAMP_COLUMN = "Timestamp";

    // Creating table query

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + TITLE_COLUMN + " TEXT,"
                    + DESCRIPTION_COLUMN + " TEXT, "
                    + TIMESTAMP_COLUMN + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
