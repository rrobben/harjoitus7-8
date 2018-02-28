package com.example.android.harjoitus5_6.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roope on 28-Feb-18.
 */

public class TrainingDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "training.db";
    private static final int DATABASE_VERSION = 1;

    public TrainingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TRAINING_TABLE = "CREATE TABLE " +
                DatabaseContract.TrainingEntry.TABLE_NAME + " (" +
                DatabaseContract.TrainingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatabaseContract.TrainingEntry.COLUMN_DATE + " DATE NOT NULL," +
                DatabaseContract.TrainingEntry.COLUMN_DURATION + " INTEGER NOT NULL," +
                DatabaseContract.TrainingEntry.COLUMN_RPE + " INTEGER NOT NULL," +
                DatabaseContract.TrainingEntry.COLUMN_SHARPNESS + " INTEGER NOT NULL," +
                DatabaseContract.TrainingEntry.COLUMN_SPORT + " TEXT" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_TRAINING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + DatabaseContract.TrainingEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
