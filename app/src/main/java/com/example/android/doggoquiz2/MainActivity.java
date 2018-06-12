package com.example.android.doggoquiz2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Tracks the quiz grade
    int finalGrade = 0;
    RadioButton q_one_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q_one_answer = (RadioButton) findViewById(R.id.q_one_one);
    }


    //This method is called with submit score is clicked.

    private int tallyQuiz(View view){
        //question one radio
        if (q_one_answer.isChecked()) {
            finalGrade = finalGrade + 20;
        }
        return finalGrade;
    }

    public void submitQuiz(View view){
        //Toast message
        Context context = getApplicationContext();
        CharSequence text = "You Scored " + finalGrade + "%";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
