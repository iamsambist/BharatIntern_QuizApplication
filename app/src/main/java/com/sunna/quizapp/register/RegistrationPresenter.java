package com.sunna.quizapp.register;

import android.content.Context;

public class RegistrationPresenter
        implements RegistrationContract.Presenter{
    private RegistrationContract.View view;
    private RegistrationModel model;

    public RegistrationPresenter(RegistrationContract.View view, Context context){
        this.view = view;
        this.model = new RegistrationModel(context);
    }

    @Override
    public void register(String userName, String email,
                         String password, String confirmPassword,
                         boolean check) {
        User user = new User(userName,email,password,confirmPassword,check);
        String message = model.register(user);
        view.showMessage(message);
    }
}
