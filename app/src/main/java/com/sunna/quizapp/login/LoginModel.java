package com.sunna.quizapp.login;

import android.content.Context;

import com.sunna.quizapp.database.DatabaseHelper;

public class LoginModel {
    DatabaseHelper databaseHelper;
    public LoginModel(Context context){
        databaseHelper = new DatabaseHelper(context);
    }
    public boolean varifyUser(String email, String password){
        // database ma check xa vane true else false return garxa
       return databaseHelper.lookFor(email,password);
    }

    public String getUserName(String email) {
        return databaseHelper.getName(email);
    }
}
