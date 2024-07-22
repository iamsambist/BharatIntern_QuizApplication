package com.sunna.quizapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sunna.quizapp.register.RegistrationModel;

public class DatabaseHelper extends SQLiteOpenHelper {
    // creating database
    public static final String db_name = "quiz.db";
    public static final int dbVersion = 1;

    // table
    public static final String tableName = "users";
     // table columns
    public static final String colName = "Name";
    public static final String colEmail = "Email";
    public static final String colPass = "Password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, db_name, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (Name TEXT, Email TEXT PRIMARY KEY,Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        onCreate(db);

    }
    public boolean insert(String userName, String email, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",userName);
        contentValues.put("Email",email);
        contentValues.put("Password",password);
        long result = db.insert(tableName,null,contentValues);

        return result != -1;
    }
    public boolean lookFor(String email, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users",null);

        boolean found = false;
        if(c!=null){
            int emailIndex = c.getColumnIndex("Email");
            int passwordIndex = c.getColumnIndex("Password");
            if(c.moveToFirst()){
                do {
                    if (c.getString(emailIndex).equals(email) && c.getString(passwordIndex).equals(password)) {
                        found = true;
                        break;
                    }
                } while (c.moveToNext());
            }

            c.close();
            }
        return found;
    }
    public String getName (String email){
        String userName ="";
        SQLiteDatabase database = this.getWritableDatabase();

        // define query
        String query = "select Name from users where Email = ? ";
        // Execute Query
        Cursor c = database.rawQuery(query,new String[]{email});

        // process the result

        if (c.moveToFirst()) {
            // Get the name from the cursor
           userName = c.getString(c.getColumnIndex("Name"));

            // Do something with the name
        }
        c.close();
        return userName;
    }
}
