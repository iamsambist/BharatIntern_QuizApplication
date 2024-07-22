package com.sunna.quizapp.register;

public interface RegistrationContract {
    interface View{
        void showMessage(String string);
    }

    interface Presenter{
        void register(String userName,
                      String email,String password,
                      String confirmPassword,boolean check);
    }
}
