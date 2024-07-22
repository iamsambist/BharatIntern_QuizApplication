package com.sunna.quizapp.register;


import android.content.Context;

import com.sunna.quizapp.database.DatabaseHelper;

public class RegistrationModel {
    Context context;
    DatabaseHelper databaseHelper;
    public RegistrationModel(Context context){
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }
    public String register(User user){
        if(user.getEmail().isEmpty() ||
                user.getName().isEmpty() ||
                user.getPassword().isEmpty() ||
                user.getConfirmPassword().isEmpty())
            return "Registration failed : please provide all details";
        if(!user.isRadioCheck())
            return "Registration Failed : Please Agree to terms & conditions";
        if(!user.getPassword().equals(user.getConfirmPassword()))
            return "Registration Failed : Please Match Passwords";
        boolean result= databaseHelper.insert(user.getName(),user.getEmail(),user.getPassword());
        if(result){
            return "Registration Success";
        }else{
            return "Registration failed";
        }
    }
}
