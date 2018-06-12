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
    RadioButton q_one_answer;
    CheckBox q_two_one, q_two_two, q_two_three;
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
        q_three_answer = q_three_answer_ed.getText().toString();

    }

    //method is called when button is clicked
    public void submitQuiz(View view){
        //Find out if answer one is chosen
        boolean isOne = q_one_answer.isChecked();

        //Find out if question two is correct
        boolean isTwo = q_two_one.isChecked() && q_two_two.isChecked() && q_two_three.isChecked();

        //Check question three
        boolean isThree = q_three_answer.equalsIgnoreCase("floof");


        //calling score calculation method?
        finalGrade = tallyQuiz(isOne, isTwo, isThree);

        //Display Toast message
        Context context = getApplicationContext();
        CharSequence text = "You Scored " + finalGrade + "%";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //This method is called with submit score is clicked.

    private int tallyQuiz(boolean isOne, boolean isTwo, boolean isThree){
        //question one radio
        if (q_one_answer.isChecked()) {
            finalGrade = finalGrade + 20;
        }

        if (q_two_one.isChecked() && q_two_two.isChecked() && q_two_three.isChecked()){
            finalGrade = finalGrade + 20;
        }

        if (q_three_answer.equalsIgnoreCase("floof")) {
            finalGrade = finalGrade + 20;
        }
        return finalGrade;
    }

}
