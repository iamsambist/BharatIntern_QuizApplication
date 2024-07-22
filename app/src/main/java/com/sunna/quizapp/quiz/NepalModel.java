package com.sunna.quizapp.quiz;

import java.util.ArrayList;

public class NepalModel implements Model{
    private ArrayList<String> question;
    private ArrayList<ArrayList<String>> options;
    private ArrayList<String>correctOptions;
    public NepalModel(){
        question = new ArrayList<>();
        options = new ArrayList<>();
        correctOptions = new ArrayList<>();
        question.add("1. Which is Nepal’s first highway ?");
        question.add("2. From which district did tea cultivation originate in Nepal?");
        options.add(new ArrayList<String>(){{
            add("a) Mahendra Highway");
            add("b) DasrathChand Highway");
            add("c) Tribhuwan Highway");
            add("d) GhodaGhodi Highway");
        }});
        options.add(new ArrayList<String>(){{
            add("a) Kathmandu");
            add("b) Elam");
            add("c) Sunsari");
            add("d) Dhankuta");
        }});
        correctOptions.add("c) Tribhuwan Highway");
        correctOptions.add("b) Elam");
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
