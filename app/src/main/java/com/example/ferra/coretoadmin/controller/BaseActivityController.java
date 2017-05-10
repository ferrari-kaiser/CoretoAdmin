package com.example.ferra.coretoadmin.controller;

import com.example.ferra.coretoadmin.activity.CadastroActivity;

/**
 * Created by ferrari on 09/05/2017.
 */

public abstract class BaseActivityController<T extends CadastroActivity> {

    protected T activity;


    protected BaseActivityController(T activity){
        this.activity = activity;
    }
}