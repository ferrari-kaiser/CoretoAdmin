package com.example.ferra.coretoadmin.aplication.basepresenter.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ferra.coretoadmin.R;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by ferrari on 15/05/2017.
 */

public class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , ZXingScannerView.ResultHandler {

    private int mLayoutView;
    private Context mContext;
    private View mMainView;

    private AlertDialog alerta;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainView = getLayoutInflater().inflate(getLayoutView(), null);

        inintView();
        setContentView(mMainView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.feed, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

           alertaSair();
        }

        return super.onOptionsItemSelected(item);
    }


    private void inintView() {

        Toolbar toolbar = (Toolbar) mMainView.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) mMainView.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) mMainView.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_validar_voucher) {
            // Handle the camera action
//            Intent intent = new Intent(getApplicationContext(), QrCodeActivity.class);
//            startActivity(intent);
            alertaQRCode();

        } else if (id == R.id.nav_cardapio) {

            Intent intent = new Intent(getApplicationContext(), CardapioActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_financeiro) {

            Intent intent = new Intent(getApplicationContext(), FinanceiroActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_cadastro) {
            Intent intent = new Intent(getApplicationContext(), AlterarCadastroActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_clientes) {

            Intent intent = new Intent(getApplicationContext(), PesquisarClientesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_configuracoes) {

        } else if (id == R.id.nav_sair) {

//            Intent  intent = new Intent(getApplicationContext(), LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.putExtra("SAIR", true);
//            startActivity(intent);


            alertaSair();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void alertaQRCode() {

        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Coreto Admin");
        //define a mensagem
        builder.setMessage("Deseja Validar o Voucher Promocional com a câmera do celular?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

               scanQR();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
//                Toast.makeText(getmContext(), "não=" + arg1, Toast.LENGTH_SHORT).show();

            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    }

    public int getmLayoutView() {
        return mLayoutView;
    }

    public void setmLayoutView(int mLayoutView) {
        this.mLayoutView = mLayoutView;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }


    public int getLayoutView() {
        return this.mLayoutView;
    }

    public void setLayoutView(int layoutView) {
        this.mLayoutView = layoutView;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            alertaSair();
        }
    }



    //atributo da classe.

    void alertaSair() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Coreto Admin");
        //define a mensagem
        builder.setMessage("Tem certeza que deseja sair?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
//                getParent().finish();
                  finish();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
//                Toast.makeText(getmContext(), "não=" + arg1, Toast.LENGTH_SHORT).show();

            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }





//    Funcionalidade QrCode

    public void scanQR() {
//        try {
//            Intent intent = new Intent(ACTION_SCAN);
//            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//            startActivityForResult(intent, 0);
//        } catch (ActivityNotFoundException anfe) {
//            showDialog(this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
//        }

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {

                    IntentResult intentResult =
                            IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

                    if (intentResult != null) {

                        String contents = intentResult.getContents();
                        String format = intentResult.getFormatName();
                        Intent intent1 = new Intent(getApplicationContext(),DetalheQrCodeActivity.class);
                        intent.putExtra("contents",contents);
                        intent.putExtra("format",format);
                        startActivity(intent1);
                        //this.elemQuery.setText(contents);
                        //this.resume = false;
                        Log.d("SEARCH_EAN", "OK, EAN: " + contents + ", FORMAT: " + format);
                    } else {
                        Log.e("SEARCH_EAN", "IntentResult je NULL!");
                    }
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Log.e("SEARCH_EAN", "CANCEL");
                }
        }
    }

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

}
