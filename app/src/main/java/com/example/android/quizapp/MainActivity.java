package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app displays a quiz form to quiz results.
 */
public class MainActivity extends AppCompatActivity {

    String error = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calls when you click on the submit button.
     */
    public void submitQuiz(View view) {

        RadioButton elbrus = findViewById(R.id.elbrus);
        boolean checkElbrus = elbrus.isChecked();

        RadioButton danube = findViewById(R.id.danube);
        boolean checkDanube = danube.isChecked();

        RadioButton no_3 = findViewById(R.id.no_3);
        boolean checkNo_3 = no_3.isChecked();

        RadioButton nicola = findViewById(R.id.nicola);
        boolean checkNicola = nicola.isChecked();

        CheckBox bangladesh = findViewById(R.id.bangladesh);
        boolean checkBangladesh = bangladesh.isChecked();

        CheckBox moldova = findViewById(R.id.moldova);
        boolean checkMoldova = moldova.isChecked();

        CheckBox georgia = findViewById(R.id.georgia);
        boolean checkGeorgia = georgia.isChecked();

        EditText city = findViewById(R.id.city);
        String cityName = city.getText().toString();

        int sum = calculate(checkElbrus, checkDanube, checkNo_3, checkNicola, checkGeorgia, checkMoldova, checkBangladesh, cityName);
        congratulateMassage(sum, error);
        error = "";
    }

    /**
     * Display the toast massage for score.
     *
     * @param sum   a sum of your score.
     * @param error a string massage from your error.
     */
    private void congratulateMassage(int sum, String error) {
        if (sum > 8) {
            Toast.makeText(this, "Congratulate! You are very good with your " + sum + " score \n" + error, Toast.LENGTH_SHORT).show();
        }
        if (sum >= 5 && sum < 8) {
            Toast.makeText(this, "Well done! Your score is " + sum + "\n" + error, Toast.LENGTH_SHORT).show();
        }
        if (sum < 5) {
            Toast.makeText(this, "Do not worry :) Your score is " + sum + "\n" + error, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method calculate your score from the quiz.
     *
     * @return sum of your score.
     */
    private int calculate(boolean checkElbrus, boolean checkDanube, boolean checkNo_3, boolean checkNicola,
                          boolean checkGeorgia, boolean checkMoldova, boolean checkBangladesh, String cityName) {
        int score = 0;

        if (checkElbrus) {
            score += 1;
        } else {
            error += "Check question 1!";
        }
        if (checkDanube) {
            score += 1;
        } else {
            error += "\nCheck question 2!";
        }
        if (checkNo_3) {
            score += 2;
        } else {
            error += "\nCheck question 3!";
        }
        if (checkNicola) {
            score += 2;
        } else {
            error += "\nCheck question 4!";
        }
        if (cityName.equals("Budapest")) {
            score += 3;
        } else {
            error += "\nCheck Question 5!";
        }
        if ((checkMoldova && checkGeorgia) && !checkBangladesh) {
            score += 1;
        } else {
            error += "\nCheck Question 6!";
        }
        return score;
    }
}