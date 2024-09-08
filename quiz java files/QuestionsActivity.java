package com.example.quiz;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class QuestionsActivity extends AppCompatActivity {
    private TextView textViewQuestion;
    private RadioButton radioButtonOption1;
    private RadioButton radioButtonOption2;
    private RadioButton radioButtonOption3;
    private Button buttonNext;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private String playerName;
    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);
        radioButtonOption3 = findViewById(R.id.radioButtonOption3);
        buttonNext = findViewById(R.id.buttonNext);

        questionList = generateQuestionList();

        Intent intent = getIntent();
        playerName = intent.getStringExtra("playerName");

        displayQuestion();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();

                currentQuestionIndex++;
                if (currentQuestionIndex < questionList.size()) {
                    displayQuestion();
                } else {
                    showResults();
                }
            }
        });
    }
    private void displayQuestion() {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        textViewQuestion.setText(currentQuestion.getQuestion());
        radioButtonOption1.setText(currentQuestion.getOption1());
        radioButtonOption2.setText(currentQuestion.getOption2());
        radioButtonOption3.setText(currentQuestion.getOption3());
        radioButtonOption1.setChecked(false);
        radioButtonOption2.setChecked(false);
        radioButtonOption3.setChecked(false);
    }

    private void checkAnswer() {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        int selectedAnswer = getSelectedAnswer();
        if (selectedAnswer == currentQuestion.getCorrectOption()) {
            score++;
        }
    }
    private int getSelectedAnswer() {
        if (radioButtonOption1.isChecked()) {
            return 1;
        } else if (radioButtonOption2.isChecked()) {
            return 2;
        } else if (radioButtonOption3.isChecked()) {
            return 3;
        } else {
            return 0;
        }
    }
    private void showResults() {
        Intent intent = new Intent(QuestionsActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("playerName", playerName);
        startActivity(intent);
        finish();
    }
    private List<Question> generateQuestionList() {
        List<Question> questionList = new ArrayList<>();

        // Add your random programming questions here
        questionList.add(new Question("Which of the following option leads to the portability and security of Java?", "Bytecode is executed by JVM", "The applet makes the Java code secure and portable", "Use of exception handling", 2));
        questionList.add(new Question("Which of the following is not a Java features?", "Dynamic", "Architecture Neutral", "Use of pointers", 3));
        questionList.add(new Question(" _____ is used to find and fix bugs in the Java programs.", "JVM", "JDB", "JRE", 2));
        questionList.add(new Question("Which of the following is a valid declaration of a char?", "char ch = '\\utea';", "char ca = 'tea';", "char cr = \\u0223;", 1));
        questionList.add(new Question("What is the return type of the hashCode() method in the Object class?", "Object", "int", "void", 2));
        questionList.add(new Question("What does the expression float a = 35 / 0 return?", "Not a Number", "Infinity", "Run time exception", 2));
        questionList.add(new Question("Which of the following for loop declaration is not valid?", "for ( int i = 99; i >= 0; i / 9 )", "for ( int i = 7; i <= 77; i += 7 )", "for ( int i = 20; i >= 2; - -i )", 1));
// Add more questions...

        return questionList;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_questions, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_home_quiz) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}