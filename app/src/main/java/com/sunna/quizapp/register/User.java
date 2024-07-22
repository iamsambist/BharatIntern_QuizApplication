package com.sunna.quizapp.register;

public class User {
    private String name;
    private String email;
    private String password;
    private boolean radioCheck;
    private String confirmPassword;


    public User(String name, String email,
                String password,String confirmPassword,boolean radioChek) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.radioCheck = radioChek;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    public boolean isRadioCheck() {
        return radioCheck;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
