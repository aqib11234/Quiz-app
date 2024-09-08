package com.example.quiz;

import java.io.Serializable;

public class Question implements Serializable {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int correctOption;

    public Question(String question, String option1, String option2, String option3, int correctOption) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}
