package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private int originScore;
    private int score;
    private TextView score2Textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        score2Textview = (TextView)findViewById(R.id.scoreTxt2);

        score = getIntent().getIntExtra("score", 0);
        originScore = score;
        setScore();
    }

    public void addScore2(View v){
        score += 1;
        setScore();
    }

    private void setScore(){
        score2Textview.setText("Score: " + score);
    }

    //This is optional, you can just press back on your phone
    //I add this in incase you had an intent for result
    public void previousAct(View v){
        Intent intentForRes = new Intent(Main2Activity.this, MainActivity.class);
        intentForRes.putExtra("original_score", originScore);
        setResult(MainActivity.RETURN_ORIGINAL_SCORE_RESULT_CODE, intentForRes);
        finish();
    }
}
