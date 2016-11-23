package com.hackathon2016.autopool;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.JsonRequest;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.google.android.gms.auth.api.Auth;
        import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
        import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
        import com.google.android.gms.auth.api.signin.GoogleSignInResult;
        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.common.SignInButton;
        import com.google.android.gms.common.api.GoogleApiClient;
        import com.google.android.gms.common.api.OptionalPendingResult;
        import com.google.android.gms.common.api.ResultCallback;
        import com.google.android.gms.common.api.Status;

        import org.json.JSONException;
        import org.json.JSONObject;

/**
 * Activity to demonstrate basic retrieval of the Google user's ID, email address, and basic
 * profile.
 */
public class Login extends AutoPoolBaseActivity implements
        View.OnClickListener {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

//    private GoogleApiClient mGoogleApiClient;
    private TextView mStatusTextView;
//    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_Without_Google:
                sign_in_Without_Google();
                break;
        }
    }

    private void sign_in_Without_Google() {

        final TextView mTextView = (TextView) findViewById(R.id.status);

        EditText UserNameTxtBox = (EditText) findViewById(R.id.NonGmailUsername);
        EditText PasswordTxtBox = (EditText) findViewById(R.id.NonGmailPassword);

        String Username=UserNameTxtBox.getText().toString();
//        if (Username==getString(R.string.NonGmailUsername)){
//            Username="";
//        }

        String Password=PasswordTxtBox.getText().toString();
//        if (Password==getString(R.string.NonGmailPassword)){
//            Password="";
//        }

        String url =" http://31.168.140.81:7878/login/"+Username+"?password="+Password;

        if (Username!="" && Password!=""){

            RequestQueue queue = Volley.newRequestQueue(this);
            // prepare the Request
            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display response
                            String result="";
                            try{
                                result = response.get("Result").toString();
                            }
                            catch (JSONException e){

                            }
                            if (result.equals("Login OK")){
                                //TODO  write to realm
                                startActivity(new Intent(getApplicationContext(), DashBoard.class));
                            }
                            else{
                                mTextView.setText("Incorrect Password");
                            }
                            Log.d("Response", response.toString());
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.toString());
                        }
                    }
            );


// Add the request to the RequestQueue.
            queue.add(getRequest);
        }
    }

//    private void makeEditable(boolean isEditable,EditText et){
//        if(isEditable){
//            et.setBackgroundDrawable(Drawable.createFromPath("Give the textbox background here"));//You can store it in some variable and use it over here while making non editable.
//            et.setFocusable(true);
//            et.setEnabled(true);
//            et.setClickable(true);
//            et.setFocusableInTouchMode(true);
//            //et.setKeyListener("Set edit text key listener here"); //You can store it in some variable and use it over here while making non editable.
//        }else{
//            et.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//            et.setFocusable(false);
//            et.setClickable(false);
//            et.setFocusableInTouchMode(false);
//            et.setEnabled(false);
//            et.setKeyListener(null);
//        }
//    }
}