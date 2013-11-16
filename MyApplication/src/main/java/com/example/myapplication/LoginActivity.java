package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lndsharkfury on 11/11/13.
 */
public class LoginActivity extends Base_Activity {

    private final String TAG = "Login";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        Log.i(TAG, "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    // Function for implementing login.
    public void usrLogin(View view) {

        String usernameStr,passwordStr;
        String dummyLogin_username =  "zanderman";
        String dummyLogin_password = "1234";

        EditText usernameIn = (EditText) findViewById(R.id.username_editText);
        EditText passwordIn = (EditText) findViewById(R.id.password_editText);

        usernameStr = usernameIn.getText().toString();
        passwordStr = passwordIn.getText().toString();

        TextView resultOut = (TextView) findViewById(R.id.result_textView);

        Log.i(TAG, ":" + usernameStr + ": = :" + dummyLogin_username + ":");
        Log.i(TAG, ":" + passwordStr + ": = :" + dummyLogin_password + ":");

        // Check to see if both strings match. (makeshift login)
        if( (usernameStr.equals(dummyLogin_username) && (passwordStr.equals(dummyLogin_password)) ) ) {

            // Gets the current screen orientaiton.
            WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
            int orientation = getResources().getConfiguration().orientation;
            int screenLayout = getResources().getConfiguration().screenLayout;

            Log.i(TAG, "Orientation: " + orientation);

            resultOut.setText("Login Success! :D");


            // Check different phone screen sizes.
            switch((screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)) {
                // 1 = portrait
                // 2 = landscape
                case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    if (orientation == 1) {
                        Intent intent = new Intent(this,ContentActivity.class);
                        intent.putExtra("username_grabbed",usernameStr);
                        startActivity(intent);
                    }

                    else if (orientation == 2) {
                        TextView textView = (TextView) findViewById(R.id.username_final);
                        textView.setText(usernameStr);
                    }
                    break;
                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                        Intent intent = new Intent(this,ContentActivity.class);
                        intent.putExtra("username_grabbed",usernameStr);
                        startActivity(intent);
                    break;
            }


        }

        else {
            resultOut.setText("Login failed :(");
        }

    }
}

