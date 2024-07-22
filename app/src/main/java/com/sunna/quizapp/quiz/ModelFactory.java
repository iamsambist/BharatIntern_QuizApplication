package com.sunna.quizapp.quiz;

public class ModelFactory {
    public static Model getProduct(int scenario) {
        switch (scenario) {
            case 1:
                return new CricketModel();
            case 2:
                return new NepalModel();
            case 3:
                return new JavaModel();
            case 4:
                return new MovieModel();
            default:
                throw new IllegalArgumentException("Unknown scenario: " + scenario);
        }
    }
}
