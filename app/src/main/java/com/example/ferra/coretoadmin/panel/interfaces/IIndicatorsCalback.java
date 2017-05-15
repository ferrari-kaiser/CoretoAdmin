package com.example.ferra.coretoadmin.panel.interfaces;

import com.example.ferra.coretoadmin.aplication.basepresenter.BaseView;

import java.util.ArrayList;

/**
 * Created by ferrari on 12/05/2017.
 */

public interface IIndicatorsCalback extends BaseView {
    void showIndicatorsSucess(ArrayList<String> category, ArrayList<Float> valueTotalCategoria , ArrayList < Integer > colors, Float totalSomaValue);
    void showIndicatorsError(String error);
}
