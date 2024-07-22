package com.sunna.quizapp.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sunna.quizapp.MainActivity;
import com.sunna.quizapp.R;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

public class QuizActivity extends AppCompatActivity implements QuizContract.View{

    QuizPresenter presenter;
    TextView questionView,scoreView;
    ListView listView;
    static int score = 0;
    int quizIndex = 0;
    int selectedQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        questionView = findViewById(R.id.main_question);
        scoreView = findViewById(R.id.main_score);
        listView = findViewById(R.id.main_list);
        score = 0;
        findTheExtra();
        loadSetUp();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String correctAns = (String) adapterView.getItemAtPosition(i);
               if(presenter.checkCorrectOption(quizIndex,correctAns)){
                   score ++;
                   gotoNextQuestion();
               } else{
                   gotoNextQuestion();
               }
            }
        });
    }

    private void findTheExtra() {
        Intent intent = getIntent();
        selectedQuiz = intent.getIntExtra("1",0);
        presenter = new QuizPresenter((QuizContract.View) this,selectedQuiz);
    }

    private void gotoNextQuestion() {
        ++quizIndex;
        if(presenter.validatLength(quizIndex)){
            presenter.updateScore(quizIndex);
            presenter.getQuestion(quizIndex);
            presenter.getOptions(quizIndex);
        } else{
            endQuiz();
        }
    }

    private void endQuiz() {
        new AlertDialog.Builder(this)
                .setTitle("You Score is "+score+" out of 2")
                .setMessage("Now Get Lost")
                .setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }).show();
    }

    private void loadSetUp() {
        presenter.getQuestion(quizIndex);
        presenter.getOptions(quizIndex);
    }

    @Override
    public void setQuestion(String question) {
        questionView.setText(question);

    }

    @Override
    public void setOptions(ArrayList<String> options) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                options);
        listView.setAdapter(adapter);
    }

    @Override
    public void setScoreText(int quizIndex) {
        scoreView.setText("0"+quizIndex+"/02");
    }
}