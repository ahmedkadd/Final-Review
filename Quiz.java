package com.example.simanste.javareviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends AppCompatActivity {
    String question;
    TextView updateLabel;
    TextView questionLabel;
    RadioButton choiceA;
    RadioButton choiceB;
    RadioButton choiceC;
    RadioButton choiceD;
    String line;
    ArrayList<String> choices;
    ArrayList<QA> QAList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        QAList = new ArrayList<QA>();

        updateLabel = findViewById(R.id.updateLabel);
        questionLabel = findViewById(R.id.questionLabel);
        choiceA = findViewById(R.id.choiceA);
        choiceB = findViewById(R.id.choiceB);
        choiceC = findViewById(R.id.choiceC);
        choiceD = findViewById(R.id.choiceD);

        Intent intent = getIntent();
        String topic = intent.getStringExtra(MainActivity.EXTRA_TOPIC);

        if (topic.equals("1")) {
            readQuestions("memoryQuestions.txt");
        }
//        else if (topic.equals("2")){
//            quiz.readQuestions();
//        } else if (topic.equals("3")) {
//            quiz.readQuestions();
//        } else {
//            quiz.readQuestions();
//        }

        displayQA();
    }

    public void displayQA() {
        questionLabel.setText(QAList.get(0).getQuestion());
        choiceA.setText(QAList.get(0).choices.get(0));
        choiceB.setText(QAList.get(0).choices.get(1));
        choiceC.setText(QAList.get(0).choices.get(2));
        choiceD.setText(QAList.get(0).choices.get(3));
    }

    public void readQuestions(String fileName){
        try {
            InputStream stream = getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            line = reader.readLine();

            while (line != null) {
                question = line;
                line = reader.readLine();
                choices = new ArrayList<String>();
                int i;
                for (i=0; i<4; i++) {
                    choices.add(line);
                    line = reader.readLine();
                }
                QA CQA = new QA(question, choices);
                QAList.add(CQA);
                line = reader.readLine();
            }

        } catch (IOException e) {
            updateLabel.setText(e.toString());
        }
    }
}