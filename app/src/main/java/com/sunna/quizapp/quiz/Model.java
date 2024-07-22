package com.sunna.quizapp.quiz;

import java.util.ArrayList;

public interface Model {
    String getQuestion(int index);
    ArrayList<String> getOptions(int index);
    String getCorrectOption(int index);
    boolean validateLength(int currentIndex);
}
