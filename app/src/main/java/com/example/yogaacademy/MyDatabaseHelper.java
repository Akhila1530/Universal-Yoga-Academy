package com.example.yogaacademy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    // Database Name
    private static final String DATABASE_NAME = "MyDatabase";
    // Database Version
    private static final int DATABASE_VERSION = 22;
    private static final String TAG = "MyDatabaseHelper"; // Define a TAG for logging

    // Constructor
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your database tables here
        String createTableSQL = "CREATE TABLE MyTable ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT, "
                + "age INTEGER)";
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades here if needed
        // You should not insert data here; this is for schema changes

        // Example of inserting data in a separate method
        insertSampleData(db);
    }

    // Method for inserting sample data
    private void insertSampleData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("name", "John");
        values.put("age", 30);
        long newRowId = db.insert("MyTable", null, values);

        if (newRowId != -1) {
            Log.d(TAG, "Row inserted with ID: " + newRowId);
        } else {
            Log.e(TAG, "Error inserting row");
        }

    }
    // Method to delete data from the table
    public void deleteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        String tableName = "MyTable";
        String whereClause = "name = ?";
        String[] whereArgs = {name};

        int rowsDeleted = db.delete(tableName, whereClause, whereArgs);

        if (rowsDeleted > 0) {
            Log.d(TAG, rowsDeleted + " rows deleted successfully");
        } else {
            Log.e(TAG, "No rows were deleted");
        }
    }
}
