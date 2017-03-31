package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MAIN_2_ACTIVITY_REQ_CODE = 101; //just on top of my head, doesn't have to be exactly 101
    public static final int RETURN_ORIGINAL_SCORE_RESULT_CODE = 1; //same as above
    private int score;
    private TextView scoreTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTextview = (TextView)findViewById(R.id.scoreTxt);
        score = 0;

        setScore();
    }

    public void addScore(View v){
        score += 1;
        setScore();
    }

    public void nextAct(View v){
        Intent main2Intent = new Intent(MainActivity.this, Main2Activity.class);
        main2Intent.putExtra("score", score);

        startActivityForResult(main2Intent, MAIN_2_ACTIVITY_REQ_CODE);
    }

    private void setScore(){
        scoreTextview.setText("Score: " + score);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == MAIN_2_ACTIVITY_REQ_CODE){
            if(resultCode == RETURN_ORIGINAL_SCORE_RESULT_CODE){
               score = data.getIntExtra("original_score", 0);
            }else{
                // if the code isn't RETURN_ORIGINAL_SCORE_RESULT_CODE, it means you got here by a back button press
                Toast.makeText(this, "back button pressed", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
