package com.hackathon2016.autopool;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;

import java.util.Timer;
import java.util.TimerTask;

//import static android.support.v7.media.MediaControlIntent.EXTRA_MESSAGE;

public class SplashScreenActivity extends AutoPoolBaseActivity {
public boolean isloggedin =false;
    //private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        //if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            //Log.d(TAG, "Got cached sign-in");
        //    GoogleSignInResult result = opr.get();
        //    isloggedin = result.isSuccess();
            //handleSignInResult(result);
        //}
//        else {
//            // If the user has not previously signed in on this device or the sign-in has expired,
//            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
//            // single sign-on will occur in this branch.
//            showProgressDialog();
//            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
//                @Override
//                public void onResult(GoogleSignInResult googleSignInResult) {
//                    hideProgressDialog();
//                    handleSignInResult(googleSignInResult);
//                }
//            });
//        }



        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if (!isloggedin){
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
