package com.example.ferra.coretoadmin.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ferrari on 12/05/2017.
 */

public class ProgresDialogUtil {
    private Context mContext;
    public ProgressDialog progress;

    public ProgresDialogUtil(Context context){
        mContext = context;
    }

    public void show(){
        progress = ProgressDialog.show(mContext, "Aguarde",
                "", true);
    }

    public void show(String title){
        progress = ProgressDialog.show(mContext, title,
                "", true);
    }

    public void show(String title,String menssage){
        progress = ProgressDialog.show(mContext, title,
                menssage, true);
    }

    public void dismiss(){
        if (progress != null) {
            progress.dismiss();
        }
    }
}
