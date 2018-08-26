package com.example.matt.nicbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.matt.MESSAGE";
    public static final String TOTAL_COUNT = "total_count";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /**
     * Show a toast
     * @param view -- the view that is clicked
     */
    public void toastMe(View view){
        //Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Here's to health and needing friends!", Toast.LENGTH_SHORT);
        myToast.show();
    }

    /**
     * increment the count number by one when the count button is clicked
     * @param view
     */
    public void countMe(View view){
        //get the middle number
        TextView showCountTextView = (TextView) findViewById(R.id.numberBox);

        //get the value of the text view, convert it to a number and increment it.
        String countString = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        count++;

        //update the text view with the new number
        showCountTextView.setText(count.toString());
    }

    /**
     * reset count when the button is clicked
     * @param view
     */
    public void countReset(View view){
        //get the textView and then set count to zero
        TextView showCountTextView = (TextView) findViewById(R.id.numberBox);
        showCountTextView.setText("0");
    }

    public void randomMe(View view){
        //create the intent to start the second activity
        Intent randomIntent = new Intent(this, RandomCountActivity.class);
        TextView countTextView = (TextView) findViewById(R.id.numberBox);
        String countString = countTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        randomIntent.putExtra(TOTAL_COUNT, count);
        startActivity(randomIntent);
    }

    public void mapsOpen (View view) {
        //open maps activity when map button is clicked
        Intent mapIntent =  new Intent(this, MapsActivity.class);
        startActivity(mapIntent);
    }
}
