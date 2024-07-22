package com.sunna.quizapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunna.quizapp.MainActivity;
import com.sunna.quizapp.R;
import com.sunna.quizapp.register.RegisterUser;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{
    private EditText userEmail, userPassword;
    private Button loginButton;
    private TextView register;

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initializeViews();
        loginPresenter = new LoginPresenter(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                loginPresenter.loginUsers(email,password);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterUser.class);
                startActivity(intent);
            }
        });
    }

    private void initializeViews() {
        userEmail = findViewById(R.id.log_email);
        userPassword = findViewById(R.id.log_pass);
        loginButton = findViewById(R.id.log_button);
        register=findViewById(R.id.log_res);
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginHome(String name) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}