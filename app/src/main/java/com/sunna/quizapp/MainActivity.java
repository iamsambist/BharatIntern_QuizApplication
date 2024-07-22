package com.sunna.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunna.quizapp.quiz.QuizActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    CardView criCard,nepalCard,javaCard;
    CardView movicard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.main_text);
        welcomeHome();
        initializeViews();
        criCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("1",1);
                startActivity(intent);
            }
        });
        nepalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("1",2);
                startActivity(intent);
            }
        });
        javaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("1",3);
                startActivity(intent);
            }
        });
        movicard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("1",4);
                startActivity(intent);
            }
        });

    }

    private void initializeViews() {

        criCard = findViewById(R.id.main_cricket);
        movicard = findViewById(R.id.main_movies);
        javaCard = findViewById(R.id.main_java);
        nepalCard = findViewById(R.id.main_nepal);
    }

    private void welcomeHome() {
        Intent intent = getIntent();
        textView.setText("Welcome");

    }
}