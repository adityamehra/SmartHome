package com.example.calendarquickstart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginActivity extends Activity {

    //protected String mAction;

    protected EditText mEmailField;
    protected EditText mPasswordField;
    protected Button mButtonSignIn;
    protected Button mButtonSignUp;
    protected ProgressBar mProgressBar;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailField = (EditText) findViewById(R.id.email);
        mPasswordField = (EditText) findViewById(R.id.password);
        mButtonSignIn = (Button) findViewById(R.id.sign_in_button);
        mButtonSignUp = (Button) findViewById(R.id.sign_up_button);
        mProgressBar = (ProgressBar) findViewById(R.id.login_progress);

        //Bundle bundle = getIntent().getExtras();
        //mAction = bundle.getString(LoginOrSignupActivity.TYPE);


        if (ParseUser.getCurrentUser() != null) {
            Intent intent = new Intent(this, NavdrawerActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        else {
            mButtonSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mProgressBar.setVisibility(View.VISIBLE);

                    username = mEmailField.getText().toString();
                    password = mPasswordField.getText().toString();
                        /*
                         * Sign up using ParseUser
                         */
                    ParseUser user = new ParseUser();
                    user.setUsername(username);
                    user.setPassword(password);

                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            mProgressBar.setVisibility(View.INVISIBLE);
                            if (e == null) {
                                // Hooray! Let them use the app now.
                                startActivity(new Intent(
                                        LoginActivity.this,
                                        NavdrawerActivity.class));
                                finish();
                            } else {
                                // Sign up didn't succeed. Look at the
                                // ParseException to figure out what went wrong
                                Toast.makeText(LoginActivity.this,
                                        "Sign up failed! Try again.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            });

            mButtonSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    username = mEmailField.getText().toString();
                    password = mPasswordField.getText().toString();

                    /*
                         * Login using ParseUser
                         */
                    ParseUser.logInInBackground(username, password,
                            new LogInCallback() {
                                public void done(ParseUser user,
                                                 ParseException e) {
                                    mProgressBar.setVisibility(View.INVISIBLE);
                                    if (user != null) {
                                        // Hooray! The user is logged in.
                                        startActivity(new Intent(
                                                LoginActivity.this,
                                                NavdrawerActivity.class));
                                        finish();
                                    } else {
                                        // Login failed. Look at the
                                        // ParseException to see what happened.
                                        Toast.makeText(
                                                LoginActivity.this,
                                                "Login failed! Try again.",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });



                }
            });

        }
    }

}

