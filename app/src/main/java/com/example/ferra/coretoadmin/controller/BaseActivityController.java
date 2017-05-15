package com.example.ferra.coretoadmin.controller;

import android.app.Activity;

/**
 * Created by ferrari on 09/05/2017.
 */

public abstract class BaseActivityController<T extends Activity> {

    protected T activity;


    protected BaseActivityController(T activity){
        this.activity = activity;
    }
}