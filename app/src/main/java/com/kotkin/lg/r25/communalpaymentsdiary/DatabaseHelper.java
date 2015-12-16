package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ServicesDB";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Electricity";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PREVIOUS = "previous";
    public static final String COLUMN_COMMON = "common";
    public static final String COLUMN_TAX = "tax";

    public DatabaseHelper(Context context) {
        super(context, "ServicesDB", null, 1);
    }

    public boolean addService(String previous, String common) {

        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("previous", previous);
        localContentValues.put("common", common);
        localSQLiteDatabase.insert("Electricity", null, localContentValues);
        localSQLiteDatabase.close();
        return true;
    }

    public Cursor getService(int id) {
        return getReadableDatabase().rawQuery("SELECT * FROM Electricity WHERE id=" + id + ";", null);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("CREATE TABLE Electricity(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "previous VARCHAR, common VARCHAR, tax VARCHAR);");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int previous, int common) {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS Electricity");
        onCreate(paramSQLiteDatabase);
    }
}
