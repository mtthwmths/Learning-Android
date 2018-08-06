package com.example.matt.nicbag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class RandomCountActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_count);
        showRandomNumber();
    }

    public void showRandomNumber () {
        TextView randomView = (TextView) findViewById(R.id.random_number_display);
        TextView headingView = (TextView) findViewById(R.id.random_number_label);

        int count = getIntent().getIntExtra(TOTAL_COUNT, 0);

        //generate the random number and display it in the correct text view.
        Random randomNumber = new Random();
        int randomInt = 0;
        if (count > 0){
            randomInt = randomNumber.nextInt(count);
        }

        randomView.setText(Integer.toString(randomInt));

        //substitute the %1d in the heading with count.
        headingView.setText(getString(R.string.random_number_info, count));
    }

}
