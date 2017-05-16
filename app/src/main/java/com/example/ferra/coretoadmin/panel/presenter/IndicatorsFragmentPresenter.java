package com.example.ferra.coretoadmin.panel.presenter;

import android.content.Context;
import android.graphics.Color;

import com.example.ferra.coretoadmin.aplication.basepresenter.BasePresenter;
import com.example.ferra.coretoadmin.panel.interfaces.IIndicatorsCalback;

import java.util.ArrayList;

/**
 * Created by ferrari on 12/05/2017.
 */

public class IndicatorsFragmentPresenter extends BasePresenter<IIndicatorsCalback> {

    private Context mContext;

    private ArrayList<String> mxData = new ArrayList<String>();
    private ArrayList<Float> myValueDate =new ArrayList<Float>();

    private Float mtotalSomaValue;
    private ArrayList < Integer > mColors=new ArrayList<Integer>();

    public IndicatorsFragmentPresenter(Context context, IIndicatorsCalback view) {
        super(context, view);
        mContext = context;
    }






    public void montarDados(Float totalValueItem, String categoriaName) {
        Float valuerPocent;
        Float resulValue;
        resulValue = totalValueItem / mtotalSomaValue;
        valuerPocent = resulValue * 100;

        myValueDate.add(valuerPocent);
        mxData.add(categoriaName);

        //add many colors
        mColors.add(Color.parseColor("#71A9D7"));
        mColors.add(Color.parseColor("#32BBCF"));
        mColors.add(Color.parseColor("#FFE461"));
        mColors.add(Color.parseColor("#0C7CBA"));
        mColors.add(Color.parseColor("#0A5988"));
        mColors.add(Color.parseColor("#5D7AA1"));
        mColors.add(Color.parseColor("#87A5AF"));
        mColors.add(Color.parseColor("#BCD0AC"));
        mColors.add(Color.parseColor("#E6E88B"));
        mColors.add(Color.parseColor("#C2A370"));
        mColors.add(Color.parseColor("#936661"));
        mColors.add(Color.parseColor("#522F84"));
        mColors.add(Color.parseColor("#FF7043"));
        mColors.add(Color.parseColor("#9FC5F8"));
        mColors.add(Color.parseColor("#FF4081"));
    }
}
