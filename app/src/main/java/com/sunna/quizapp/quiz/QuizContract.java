package com.sunna.quizapp.quiz;

import java.util.ArrayList;

public interface QuizContract {
    interface View{
        void setQuestion(String question);
        void setOptions(ArrayList<String> options);
        void setScoreText(int scoreText);
    }
    interface Presenter{
        void getQuestion(int index);
        void getOptions(int index);
        boolean checkCorrectOption(int index,String ansClicked);
        boolean validatLength(int currentIndex);
        void updateScore(int item);
    }
}
