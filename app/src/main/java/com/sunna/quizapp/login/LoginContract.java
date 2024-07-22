package com.sunna.quizapp.login;

public interface LoginContract {
    interface View{
        void showMessage(String message);
        void loginHome(String name);
    }
    interface Persenter{
        void loginUsers(String userEmail, String userPassword);
    }
}
