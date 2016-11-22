package com.hackathon2016.autopool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

//import static android.support.v7.media.MediaControlIntent.EXTRA_MESSAGE;

public class SplashScreenActivity extends AutoPoolBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final boolean isloggedin =false;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if (isloggedin){
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
                else{
                    startActivity(new Intent(getApplicationContext(), DashBoard.class));
                }
            }
        }, 5000);
    }

    /** Called when the user clicks the Send button */
    public void continueToMap(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MapsActivity.class);
        EditText editText = (EditText) findViewById(R.id.map);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
