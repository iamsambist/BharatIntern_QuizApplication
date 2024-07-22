package com.sunna.quizapp.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunna.quizapp.R;

public class RegisterUser extends AppCompatActivity implements RegistrationContract.View {
    EditText email, password,confirmPassword,name;
    RadioButton checkButton;
    Button signUpButton;
    RegistrationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user_activity);
        intializeViews();
        presenter = new RegistrationPresenter((RegistrationContract.View) this,this);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String useremail =email.getText().toString();
                String userPass = password.getText().toString();
                String conPass = confirmPassword.getText().toString();
                boolean check = checkButton.isChecked();
                presenter.register(userName,useremail,userPass,conPass,check);
            }
        });

    }

    private void intializeViews() {
        email = findViewById(R.id.res_email);
        password = findViewById(R.id.res_pass);
        confirmPassword = findViewById(R.id.res_conpass);
        name = findViewById(R.id.res_name);
        checkButton = findViewById(R.id.res_radio);
        signUpButton = findViewById(R.id.res_button);
    }

    @Override
    public void showMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}