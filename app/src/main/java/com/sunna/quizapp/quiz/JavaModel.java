package com.sunna.quizapp.quiz;

import java.util.ArrayList;

public class JavaModel implements Model{
    private ArrayList<String> question;
    private ArrayList<ArrayList<String>> options;
    private ArrayList<String>correctOptions;
    public JavaModel(){
        question = new ArrayList<>();
        options = new ArrayList<>();
        correctOptions = new ArrayList<>();
        question.add("1. Which keyword is used to create an object in Java?");
        question.add("2. What is the default value of an int variable in Java?");
        options.add(new ArrayList<String>(){{
            add("a) new");
            add("b) create");
            add("c) class");
            add("d) object");
        }});
        options.add(new ArrayList<String>(){{
            add("a) 0");
            add("b) 1");
            add("c) null");
            add("d) -1");
        }});
        correctOptions.add("a) new");
        correctOptions.add("a) 0");
    }
    @Override
    public String getQuestion(int index) {
        return question.get(index);
    }

    @Override
    public ArrayList<String> getOptions(int index) {
        return options.get(index);
    }

    @Override
    public String getCorrectOption(int index) {
        return correctOptions.get(index);
    }

    @Override
    public boolean validateLength(int currentIndex) {
        return currentIndex < question.size();
    }
}
