package com.example.simpletimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // implements interface that allows any view-able item to listen for clicks
    // using a this. command (?)


    private MyCountdownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime = 50 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // repopulates data from previous session(s)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // associates java with layout file

        startB = findViewById(R.id.button);
        startB.setOnClickListener(this);

/*      // makes it clear which button was clicked and what to do
        // but requires not implementing the interface (?)
        @Override
        public void onClick(View v) {
            if(!timerHasStarted) {
                countDownTimer.start();
                timerHasStarted = true;

                // pulls from the string file
                String startString = getString(R.string.startLabel);
                startB.setText(startString);

            } else {
                countDownTimer.cancel();
                timerHasStarted = false;

                // pulls from the string file
                startB.setText(getText(R.string.resetLabel));
            }
        }*/

        // could add an if-statement to repopulate data

        // code from lab?
        //startB = (Button) this.findViewById(R.id.button);

        /*text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime));*/
    }

    @Override
    public void onClick(View view) {
        if(!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;

            // pulls from the string file
            String startString = getString(R.string.startLabel);
            startB.setText(startString);

        } else {
            countDownTimer.cancel();
            timerHasStarted = false;

            // pulls from the string file
            startB.setText(getText(R.string.resetLabel));
        }
    }

    public class MyCountdownTimer extends CountDownTimer {
        public MyCountdownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onFinish() {
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
        }
        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("Time remain: " + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
        }
    }

}