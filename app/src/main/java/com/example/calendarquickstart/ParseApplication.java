//This is the the class that you get from parse.com for your application. 
//You have to configure it according to your IDs. 
//Please check parse.com.


package com.example.calendarquickstart;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by Aditya on 11/16/15.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "Enter the ID you get from Parse Here", "Enter the ID you get from Parse Here");

        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }
}
