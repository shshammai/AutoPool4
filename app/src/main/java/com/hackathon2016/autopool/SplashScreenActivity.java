package com.hackathon2016.autopool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.hackathon2016.autopool.Entities.Config;

import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;

//import static android.support.v7.media.MediaControlIntent.EXTRA_MESSAGE;

public class SplashScreenActivity extends AppCompatActivity {
public boolean IsLoggedIn =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Realm realm = Realm.getDefaultInstance();
        try{
        final Config CurrentConfig = realm.where(Config.class).findFirst();

        if (CurrentConfig.User!=null){
            IsLoggedIn=true;
            startActivity(new Intent(getApplicationContext(), DashBoard.class));
        }
        }
        catch (Exception e){

        }


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if (!IsLoggedIn){
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
                else{
                    startActivity(new Intent(getApplicationContext(), DashBoard.class));
                }
            }
        }, 2000);
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
