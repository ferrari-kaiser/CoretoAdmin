package com.example.ferra.coretoadmin.aplication.basepresenter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ferra.coretoadmin.R;

public class DetalheQrCodeActivity extends AppCompatActivity {

    TextView mContent;
    TextView mFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_qr_code);

        String contents = getIntent().getStringExtra("contents");
        String format = getIntent().getStringExtra("format");

        mContent = (TextView) findViewById(R.id.contents);
        mFormat = (TextView) findViewById(R.id.format);


        if(contents !=null){
            mContent.setText(contents);
        }

        if(format !=null){
            mFormat.setText(format);
        }
    }
}
