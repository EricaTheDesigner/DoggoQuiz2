package com.example.android.doggoquiz2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton q_one_radiobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton q_one_answer = (RadioButton) findViewById(R.id.q_one_one);
    }

    //Tracks the quiz grade
    int finalGrade = 0;

    //Question One

    private boolean question_one() {

        //QUESTION ONE
        RadioButton q_one_answer = (RadioButton) findViewById(R.id.q_one_one);
        if (q_one_answer.isChecked()) {
            finalGrade = finalGrade + 20;
        }
        return false;
    }


//        public void showGrade(View v) {
//            Context context = getApplicationContext();
//            CharSequence text = "You Scored " + finalGrade + "%";
//            int duration = Toast.LENGTH_LONG;
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }

}
