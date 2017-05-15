package com.example.ferra.coretoadmin.panel.presenter;

import android.content.Context;
import android.graphics.Color;

import com.example.ferra.coretoadmin.aplication.basepresenter.BasePresenter;
import com.example.ferra.coretoadmin.banco.domain.Spent;
import com.example.ferra.coretoadmin.banco.domain.dao.SpentDAO;
import com.example.ferra.coretoadmin.panel.interfaces.IIndicatorsCalback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ferrari on 12/05/2017.
 */

public class IndicatorsFragmentPresenter extends BasePresenter<IIndicatorsCalback> {

    private Context mContext;
    private List<Spent> mList = new ArrayList<Spent>();
    private SpentDAO mDatabaseHelper;

    private ArrayList<String> mxData = new ArrayList<String>();
    private ArrayList<Float> myValueDate =new ArrayList<Float>();
    private Float TotalValueResidencia = 0.0F;
    private Float TotalValueAlimentation = 0.0F;
    private Float TotalValueLuz = 0.0F;
    private Float TotalValueInternet = 0.0F;
    private Float TotalValueOthers = 0.0F;
    private Float TotalValueWater = 0.0F;
    private Float TotalValueTransport = 0.0F;
    private Float mtotalSomaValue;
    private ArrayList < Integer > mColors=new ArrayList<Integer>();

    public IndicatorsFragmentPresenter(Context context, IIndicatorsCalback view) {
        super(context, view);
        mContext = context;
    }

    public void listSpents(){

        mDatabaseHelper = new SpentDAO(mContext);
        mList = mDatabaseHelper.listarGastos();

        if (!mList.isEmpty()) {
            compactaDados();
            mView.showIndicatorsSucess(mxData,myValueDate,mColors,mtotalSomaValue);
        }else {
            mView.showIndicatorsError("");
        }
    }

    public void compactaDados() {
        Float oldvalue = 0.0F;

//        Combustivel
        boolean mCombustivelValidate = false;
        Float oldValueResidencia = 0.0F;

//        Alimentaçao
        boolean mAlimentationValidate = false;
        Float oldValueAlimentation = 0.0F;

//        Transporte
        boolean mtransportValidate = false;
        Float oldValuetransport = 0.0F;

//        Água
        boolean mWaterValidate = false;
        Float oldValueWater = 0.0F;

//        Luz
        boolean mLuzValidate = false;
        Float oldValueLuz = 0.0F;

//        Internet
        boolean mInternetValidate = false;
        Float oldValueInternet = 0.0F;

//        Outros
        boolean mOuthersValidate = false;
        Float oldValueOthers = 0.0F;


        for (int i = 0; i < mList.size(); i++) {
            Spent mItem = this.mList.get(i);
            mtotalSomaValue = oldvalue + mItem.getValor();
            oldvalue = mtotalSomaValue;

            switch (mItem.getCategoria()) {
                case "Alimentação":
                    TotalValueAlimentation = oldValueAlimentation + mItem.getValor();
                    oldValueAlimentation = TotalValueAlimentation;
                    mAlimentationValidate = true;
                    break;
                case "Residencia":
                    TotalValueResidencia = oldValueResidencia + mItem.getValor();
                    oldValueResidencia = TotalValueResidencia;
                    mCombustivelValidate = true;
                    break;
                case "Transporte":
                    TotalValueTransport = oldValuetransport + mItem.getValor();
                    oldValuetransport = TotalValueTransport;
                    mtransportValidate = true;
                    break;
                case "Educação":
                    TotalValueWater = oldValueWater + mItem.getValor();
                    oldValueWater = TotalValueWater;
                    mWaterValidate = true;
                    break;
                case "Saúde":
                    TotalValueLuz = oldValueLuz + mItem.getValor();
                    oldValueLuz = TotalValueLuz;
                    mLuzValidate = true;
                    break;
                case "Entreterimento":
                    TotalValueInternet = oldValueInternet + mItem.getValor();
                    oldValueInternet = TotalValueInternet;
                    mInternetValidate = true;
                    break;
                case "Outros":
                    TotalValueOthers = oldValueOthers + mItem.getValor();
                    oldvalue = TotalValueOthers;
                    mOuthersValidate = true;
                    break;
            }
        }

        if (mCombustivelValidate) {
            montarDados(TotalValueResidencia, "Residencia");
        }
        if (mAlimentationValidate) {
            montarDados(TotalValueAlimentation, "Alimentação");
        }
        if (mtransportValidate) {
            montarDados(TotalValueTransport, "Transporte");
        }
        if (mWaterValidate) {
            montarDados(TotalValueWater, "Educação");
        }
        if (mLuzValidate) {
            montarDados(TotalValueLuz, "Saúde");
        }
        if (mInternetValidate) {
            montarDados(TotalValueInternet, "Entreterimento");
        }
        if (mOuthersValidate) {
            montarDados(TotalValueOthers, "Outros");
        }

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
