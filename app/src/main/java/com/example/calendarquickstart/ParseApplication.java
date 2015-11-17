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

        Parse.initialize(this, "  M3vtaLmFwuNQBcTYoaxpZxA9AaVR3UVoi3pf50Hx", "1gvoJIDf4359RiTT090BjDxcFrtaEIps6OAtkBVA");

        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }
}
