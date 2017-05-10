package com.example.ferra.coretoadmin.util.mask;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ferra.coretoadmin.util.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ferrari on 09/05/2017.
 */

public class MaskEditTextChangedListener implements TextWatcher {

    private static MaskEditTextChangedListener instance;

    private String mMask;
    private EditText mEditText;
    private TextView mTextView;
    private Set<String> symbolMask = new HashSet<String>();
    private boolean isUpdating;
    private String old = "";
    private boolean mIsTextView;

    public MaskEditTextChangedListener(String mask, EditText editText) {
        mMask = mask;
        mEditText = editText;
        initSymbolMask();
        mIsTextView = false;
    }

    public MaskEditTextChangedListener(String mask, TextView editText) {
        mMask = mask;
        mTextView = editText;
        initSymbolMask();
        mIsTextView = true;
    }


    private void initSymbolMask(){
        for (int i=0; i < mMask.length(); i++){
            char ch = mMask.charAt(i);
            if (ch != '#')
                symbolMask.add(String.valueOf(ch));
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = Utils.unmask(s.toString(), symbolMask);
        String mascara = "";

        if (isUpdating) {
            old = str;
            isUpdating = false;
            return;
        }

        if(str.length() > old.length())
            mascara = Utils.mask(mMask,str);
        else
            mascara = s.toString();

        isUpdating = true;

        if(!mIsTextView) {
            mEditText.setText(mascara);
            mEditText.setSelection(mascara.length());
        }else{
            mTextView.setText(mascara);
//            mTextView.setSelection(mascara.length());
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void afterTextChanged(Editable s) {

    }
}
