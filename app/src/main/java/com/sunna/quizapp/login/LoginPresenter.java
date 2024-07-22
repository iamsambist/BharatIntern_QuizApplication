package com.sunna.quizapp.login;

import android.content.Context;
import android.content.Intent;

import com.sunna.quizapp.register.RegistrationContract;

public class LoginPresenter implements LoginContract.Persenter {
    private LoginContract.View view;
    private LoginModel loginModel;

    public LoginPresenter(Context context) {
        this.view = (LoginContract.View) context;
        loginModel = new LoginModel(context);
    }


    @Override
    public void loginUsers(String userEmail, String userPassword) {

        if(loginModel.varifyUser(userEmail,userPassword)){
            view.showMessage("Login successs");
            String name = loginModel.getUserName(userEmail);
            view.loginHome(name);
        }else{
            view.showMessage("login failed");
        }
    }
}
