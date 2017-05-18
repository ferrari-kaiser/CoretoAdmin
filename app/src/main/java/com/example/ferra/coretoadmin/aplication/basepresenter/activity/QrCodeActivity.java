package com.example.ferra.coretoadmin.aplication.basepresenter.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.ferra.coretoadmin.R;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        scanQR();
    }


    public void scanQR() {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
//            showDialog(this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        switch (requestCode) {
//            case IntentIntegrator.REQUEST_CODE:
//                if (resultCode == Activity.RESULT_OK) {
//
//                    IntentResult intentResult =
//                            IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
//
//                    if (intentResult != null) {
//
//                        String contents = intent.getStringExtra("SCAN_RESULT");
//                        String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
//
////                        String contents = intentResult.getContents();
////                        String format = intentResult.getFormatName();
//                        Intent intent1 = new Intent(getApplicationContext(),DetalheQrCodeActivity.class);
//                        intent.putExtra("contents",contents);
//                        intent.putExtra("format",format);
//                        startActivity(intent1);
//                        //this.elemQuery.setText(contents);
//                        //this.resume = false;
//                        Log.d("SEARCH_EAN", "OK, EAN: " + contents + ", FORMAT: " + format);
//                    } else {
//                        Log.e("SEARCH_EAN", "IntentResult je NULL!");
//                    }
//                } else if (resultCode == Activity.RESULT_CANCELED) {
//                    Log.e("SEARCH_EAN", "CANCEL");
//                }
//        }
//    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();

        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
