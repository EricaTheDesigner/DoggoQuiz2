package com.example.android.doggoquiz2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Tracks the quiz grade
    int finalGrade = 0;
    RadioButton q_one_answer, q_four_answer;
    CheckBox q_two_one, q_two_two, q_two_three, q_five_one, q_five_two, q_five_three;
    String q_three_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q_one_answer = (RadioButton) findViewById(R.id.q_one_one);
        q_two_one = (CheckBox) findViewById(R.id.q_two_one);
        q_two_two = (CheckBox) findViewById(R.id.q_two_two);
        q_two_three = (CheckBox) findViewById(R.id.q_two_three);
        EditText q_three_answer_ed = findViewById(R.id.q_three_floof);
        q_three_answer = q_three_answer_ed.getText().toString().trim();
        q_four_answer = (RadioButton) findViewById(R.id.q_four);
        q_five_one = (CheckBox) findViewById(R.id.q_five_one);
        q_five_two = (CheckBox) findViewById(R.id.q_five_two);
        q_five_three = (CheckBox) findViewById(R.id.q_five_three);

    }

    //method is called when button is clicked
    public void submitQuiz(View view){
        //Find out if answer one is chosen
        boolean isOne = q_one_answer.isChecked();

        //Find out if question two is correct
        boolean isTwo = q_two_one.isChecked() && q_two_two.isChecked() && q_two_three.isChecked();

        //Check if question three is correct
        boolean isThree = q_three_answer.equalsIgnoreCase("floof");

        //Check if question four is correct
        boolean isFour = q_four_answer.isChecked();

        //Check if question five is correct
        boolean isFive = q_five_one.isChecked() && q_five_two.isChecked() && q_five_three.isChecked();


        //calling score calculation method?
        finalGrade = tallyQuiz(isOne, isTwo, isThree, isFour, isFive);

        //Display Toast message
        if(finalGrade == 0){
            Context context = getApplicationContext();
            CharSequence text = "THE DOGGO ATE YOUR HOMEWORK " + finalGrade + "%";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else{
            Context context = getApplicationContext();
            CharSequence text = "You Scored " + finalGrade + "%";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    //This method is called with submit score is clicked.

    private int tallyQuiz(boolean isOne, boolean isTwo, boolean isThree, boolean isFour, boolean isFive){
        finalGrade = 0;
        //question one radio
        if (q_one_answer.isChecked()) {
            finalGrade += 20;
        }

        if (q_two_one.isChecked() && q_two_two.isChecked() && q_two_three.isChecked()){
            finalGrade += 20;
        }

        if (q_three_answer.equalsIgnoreCase("floof")) {
            finalGrade += 20;
        }

        if (q_four_answer.isChecked()){
            finalGrade += 20;
        }

        if (q_five_one.isChecked() && q_five_two.isChecked() && q_five_three.isChecked()){
            finalGrade += 20;
        }
        return finalGrade;
    }

}
