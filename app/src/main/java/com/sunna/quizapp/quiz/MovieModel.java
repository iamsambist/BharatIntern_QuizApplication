package com.sunna.quizapp.quiz;

import java.util.ArrayList;

public class MovieModel implements Model {
    private ArrayList<String> question;
    private ArrayList<ArrayList<String>> options;
    private ArrayList<String>correctOptions;
    public MovieModel(){
        question = new ArrayList<>();
        options = new ArrayList<>();
        correctOptions = new ArrayList<>();
        question.add("1. Who directed the movie Dust Devil ?");
        question.add("2. The director of The Frighteners also directed which of these movies?");
        options.add(new ArrayList<String>(){{
            add("A. Stephen King");
            add("B. Renny Harlin");
            add("C. Wes Craven");
            add("D. Richard Stanley");
        }});
        options.add(new ArrayList<String>(){{
            add("A. Swordfish");
            add("B. Day Of The Dead");
            add("C. Jason X");
            add("D. Lord Of The Rings");
        }});
        correctOptions.add("D. Richard Stanley");
        correctOptions.add("D. Lord Of The Rings");
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
