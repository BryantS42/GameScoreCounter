package com.example.gamescorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.gamescorecounter.extra.MESSAGE";
    private static final String SAVED_VAL = "safe";
    private static final String SAVED_VAL2 = "safe2";
    private TextView scoreA;
    private TextView scoreB;
    private TextView teamA;
    private TextView teamB;
    private Button goalA;
    private Button goalB;
    public int countA = 0;
    public int countB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA = findViewById(R.id.team1);
        teamB = findViewById(R.id.team2);
        scoreA = findViewById(R.id.scoret1);
        scoreB = findViewById(R.id.scoret2);
        goalA = findViewById(R.id.button1);
        goalB = findViewById(R.id.button2);
        scoreA.setText(String.valueOf(countA));
        scoreB.setText(String.valueOf(countB));
        if(savedInstanceState != null){
            CharSequence safe1 = savedInstanceState.getCharSequence(SAVED_VAL);
            String safe2 = savedInstanceState.getString(SAVED_VAL2);
            scoreA.setText(safe1);
            scoreB.setText(safe2);
            countA = Integer.parseInt(safe1.toString());
            countB = Integer.parseInt(safe2);
        }
    }

    public void onClick(View view){
        countA++;
        scoreA.setText(String.valueOf(countA));
        if(countA == 5) {
            int result = (5 - countB);
            Intent intent = new Intent(this, WinnerActivity.class);
            String message = teamA.getText().toString() + " won by " + result + " goals";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
    public void goal2(View view){
        countB++;
        scoreB.setText(String.valueOf(countB));
        if(countB == 5) {
            int result2 = (5 - countA);
            Intent intent2 = new Intent(this, WinnerActivity.class);
            String message = teamB.getText().toString() +": won by " + result2 + " goals" ;
            intent2.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent2);
        }
    }

    public void onSaveInstanceState(Bundle outState){
        outState.putCharSequence(SAVED_VAL, scoreA.getText().toString() );
        outState.putString(SAVED_VAL2, scoreB.getText().toString());
        super.onSaveInstanceState(outState);
    }


}