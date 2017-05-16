package com.example.ferra.coretoadmin.aplication.basepresenter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ferra.coretoadmin.R;
import com.example.ferra.coretoadmin.panel.fragment.IndicadorGastoFragment;

public class FinanceiroActivity extends AppCompatActivity {

    private IndicadorGastoFragment mIndicadorGastoFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        getSupportFragmentManager().findFragmentById(R.id.tv_title);


        android.support.v4.app.FragmentManager mFragmentManager;
        android.support.v4.app.FragmentTransaction mFragmentTransaction;

        mIndicadorGastoFragment = new IndicadorGastoFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container, mIndicadorGastoFragment);
        mFragmentTransaction.commit();





    }




}
