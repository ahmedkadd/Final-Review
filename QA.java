package com.example.simanste.javareviewapp;

import java.util.ArrayList;
import java.util.Collections;

public class QA {

    private String question;
    private String answer;
    public ArrayList<String> choices;

    public QA(String q, ArrayList<String> c) {
        this.question=q;
        this.choices = c;
        this.answer=choices.get(0);
        Collections.shuffle(choices);
    }

    public String getQuestion() { return this.question; }

    public String getAnswer() { return this.answer; }

    public boolean checkAnswer (String userAnswer) {
        return this.answer.equals(userAnswer);
    }
}