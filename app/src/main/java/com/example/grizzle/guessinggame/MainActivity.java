package com.example.grizzle.guessinggame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int secret;
    private int guessCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secret = getRandomInt(0, 100);
        guessCount = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {
        int guess = getGuess();
        String hint = getHint(guess);
        showHint(hint);
    }

    private void showHint(String hint) {
        TextView textView = (TextView) findViewById(R.id.hint);
        textView.setText(hint);
    }

    private String getHint(int guess) {
        String hint;

        if (guess > secret) {
            hint = "lower than " + guess;
        } else if (guess < secret) {
            hint = "higher than " + guess;
        } else {
            hint = "You guessed in " + guessCount + " attempts.";
        }

        return hint;
    }

    private int getGuess() {
        guessCount++;
        TextView input = (TextView) findViewById(R.id.input);
        return Integer.parseInt(input.getText().toString());
    }

    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
