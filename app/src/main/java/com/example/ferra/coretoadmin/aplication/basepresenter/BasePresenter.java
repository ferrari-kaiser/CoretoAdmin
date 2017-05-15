package com.example.ferra.coretoadmin.aplication.basepresenter;

import android.content.Context;

import com.example.ferra.coretoadmin.util.ProgresDialogUtil;

/**
 * Created by ferrari on 12/05/2017.
 */

public abstract class BasePresenter<T extends BaseView> {

    protected Context mContext;
    ProgresDialogUtil mProgresDialogUtil;
    public T mView;

    protected BasePresenter(T view) {
        if (!(view instanceof Context)) {
            throw new RuntimeException("Your view must be instance of Context for this constructor");
        }


        mContext = (Context) view;
        mProgresDialogUtil = new ProgresDialogUtil(mContext);
        mView = view;
    }

    public BasePresenter(Context context, T view) {
        mContext = context;
        mProgresDialogUtil = new ProgresDialogUtil(mContext);
        mView = view;
    }
}
