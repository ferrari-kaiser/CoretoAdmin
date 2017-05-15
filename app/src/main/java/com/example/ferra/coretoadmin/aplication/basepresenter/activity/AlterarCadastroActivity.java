package com.example.ferra.coretoadmin.aplication.basepresenter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ferra.coretoadmin.R;
import com.example.ferra.coretoadmin.controller.AlterarCadastroController;

public class AlterarCadastroActivity extends AppCompatActivity {

    AlterarCadastroController mController = new AlterarCadastroController(this);

    private android.widget.EditText ednome;
    private android.widget.EditText edcpf;
    private android.widget.EditText eddatanascimento;
    private android.widget.EditText ednacionalidade;
    private android.widget.Spinner spsexo;
    private android.widget.Spinner spestadocivil;
    private android.widget.EditText edcep;
    private android.widget.EditText edendereco;
    private android.widget.EditText ednumerocasa;
    private android.widget.EditText edcomplemento;
    private android.widget.EditText edbairro;
    private android.widget.Spinner spcidade;
    private android.widget.Spinner spestado;
    private android.widget.EditText edemail;
    private android.widget.EditText edtelefoneresidencial;
    private android.widget.EditText edtelefonecelular;
    private android.widget.Button btnsalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_cadastro);
        initView();

        mController.initDataComponent();

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.isValidateActivity();

                if(mController.isValidateActivity()){
                    Toast.makeText(getApplicationContext(),"Tudo Certo",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Deu Errado",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initView() {

        this.btnsalvar = (Button) findViewById(R.id.btn_salvar);
        this.edtelefonecelular = (EditText) findViewById(R.id.ed_telefone_celular);
        this.edtelefoneresidencial = (EditText) findViewById(R.id.ed_telefone_residencial);
        this.edemail = (EditText) findViewById(R.id.ed_email);
        this.spestado = (Spinner) findViewById(R.id.sp_estado);
        this.edbairro = (EditText) findViewById(R.id.ed_bairro);
        this.edcomplemento = (EditText) findViewById(R.id.ed_complemento);
        this.ednumerocasa = (EditText) findViewById(R.id.ed_numero_casa);
        this.edendereco = (EditText) findViewById(R.id.ed_endereco);
        this.edcep = (EditText) findViewById(R.id.ed_cep);
        this.spestadocivil = (Spinner) findViewById(R.id.sp_estado_civil);
        this.spsexo = (Spinner) findViewById(R.id.sp_sexo);
        this.ednacionalidade = (EditText) findViewById(R.id.ed_nacionalidade);
        this.eddatanascimento = (EditText) findViewById(R.id.ed_data_nascimento);
        this.edcpf = (EditText) findViewById(R.id.ed_cpf);
        this.ednome = (EditText) findViewById(R.id.ed_nome);
    }

    //get Set de Views

    public EditText getEdnome() {
        return ednome;
    }

    public void setEdnome(EditText ednome) {
        this.ednome = ednome;
    }

    public EditText getEdcpf() {
        return edcpf;
    }

    public void setEdcpf(EditText edcpf) {
        this.edcpf = edcpf;
    }

    public EditText getEddatanascimento() {
        return eddatanascimento;
    }

    public void setEddatanascimento(EditText eddatanascimento) {
        this.eddatanascimento = eddatanascimento;
    }

    public EditText getEdnacionalidade() {
        return ednacionalidade;
    }

    public void setEdnacionalidade(EditText ednacionalidade) {
        this.ednacionalidade = ednacionalidade;
    }

    public Spinner getSpsexo() {
        return spsexo;
    }

    public void setSpsexo(Spinner spsexo) {
        this.spsexo = spsexo;
    }

    public Spinner getSpestadocivil() {
        return spestadocivil;
    }

    public void setSpestadocivil(Spinner spestadocivil) {
        this.spestadocivil = spestadocivil;
    }

    public EditText getEdcep() {
        return edcep;
    }

    public void setEdcep(EditText edcep) {
        this.edcep = edcep;
    }

    public EditText getEdendereco() {
        return edendereco;
    }

    public void setEdendereco(EditText edendereco) {
        this.edendereco = edendereco;
    }

    public EditText getEdnumerocasa() {
        return ednumerocasa;
    }

    public void setEdnumerocasa(EditText ednumerocasa) {
        this.ednumerocasa = ednumerocasa;
    }

    public EditText getEdcomplemento() {
        return edcomplemento;
    }

    public void setEdcomplemento(EditText edcomplemento) {
        this.edcomplemento = edcomplemento;
    }

    public EditText getEdbairro() {
        return edbairro;
    }

    public void setEdbairro(EditText edbairro) {
        this.edbairro = edbairro;
    }

    public Spinner getSpcidade() {
        return spcidade;
    }

    public void setSpcidade(Spinner spcidade) {
        this.spcidade = spcidade;
    }

    public Spinner getSpestado() {
        return spestado;
    }

    public void setSpestado(Spinner spestado) {
        this.spestado = spestado;
    }

    public EditText getEdemail() {
        return edemail;
    }

    public void setEdemail(EditText edemail) {
        this.edemail = edemail;
    }

    public EditText getEdtelefoneresidencial() {
        return edtelefoneresidencial;
    }

    public void setEdtelefoneresidencial(EditText edtelefoneresidencial) {
        this.edtelefoneresidencial = edtelefoneresidencial;
    }

    public EditText getEdtelefonecelular() {
        return edtelefonecelular;
    }

    public void setEdtelefonecelular(EditText edtelefonecelular) {
        this.edtelefonecelular = edtelefonecelular;
    }
}
