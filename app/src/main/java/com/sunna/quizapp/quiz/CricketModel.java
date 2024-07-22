package com.sunna.quizapp.quiz;

import java.util.ArrayList;

public class CricketModel implements Model{
    private ArrayList<String> question;
    private ArrayList<ArrayList<String>> options;
    private ArrayList<String>correctOptions;
    public CricketModel(){
        question = new ArrayList<>();
        options = new ArrayList<>();
        correctOptions = new ArrayList<>();
        question.add("1. How many players are there in " +
                "each cricket team on the field during a match?");
        question.add("2. What is the name of the three " +
                "wooden stumps topped by two bails on which the ball is aimed?");
        options.add(new ArrayList<String>(){{
            add("a) 8");
            add("b) 10");
            add("c) 11");
            add("d) 12");
        }});
        options.add(new ArrayList<String>(){{
            add("a) Wicket");
            add("b) Pitch");
            add("c) Boundary");
            add("d) Dots");
        }});
        correctOptions.add("c) 11");
        correctOptions.add("a) Wicket");
    }
    public String getQuestion(int index){
        return question.get(index);
    }
    public ArrayList<String> getOptions(int index){
        return options.get(index);
    }
    public String getCorrectOption(int index){
        return correctOptions.get(index);
    }

    public boolean validateLength(int currentIndex) {
        return currentIndex < question.size();
    }
}
