package com.example.ferra.coretoadmin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ferra.coretoadmin.R;

public class DetalheQrCodeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_qr_code);

        String contents = getIntent().getStringExtra("SCAN_RESULT");
        String format = getIntent().getStringExtra("SCAN_RESULT_FORMAT");

        TextView mContent = (TextView) findViewById(R.id.contents);
        TextView mFormat = (TextView) findViewById(R.id.format);


        if(contents !=null){
            mContent.setText(contents);
        }

        if(format !=null){
            mFormat.setText(format);
        }
    }
}
