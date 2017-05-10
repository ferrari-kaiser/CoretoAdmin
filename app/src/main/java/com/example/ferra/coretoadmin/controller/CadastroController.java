package com.example.ferra.coretoadmin.controller;

import com.example.ferra.coretoadmin.R;
import com.example.ferra.coretoadmin.activity.CadastroActivity;
import com.example.ferra.coretoadmin.util.Utils;
import com.example.ferra.coretoadmin.util.mask.MaskEditTextChangedListener;
import com.example.ferra.coretoadmin.util.validations.ValidationsForms;

/**
 * Created by ferrari on 09/05/2017.
 */


public class CadastroController extends BaseActivityController<CadastroActivity> {


    public CadastroController(CadastroActivity activity) {
        super(activity);
    }

    public void initDataComponent(){

        activity.getEdcpf().addTextChangedListener(new MaskEditTextChangedListener("###.###.###-##", activity.getEdcpf()));
        activity.getEddatanascimento().addTextChangedListener(new MaskEditTextChangedListener("##/##/####", activity.getEddatanascimento()));
        activity.getEdcep().addTextChangedListener(new MaskEditTextChangedListener("##.###-###", activity.getEdcep()));
        activity.getEdtelefoneresidencial().addTextChangedListener(new MaskEditTextChangedListener("(##)####-####", activity.getEdtelefoneresidencial()));
        activity.getEdtelefonecelular().addTextChangedListener(new MaskEditTextChangedListener("(##)#####-####", activity.getEdtelefonecelular()));

        Utils.nextInputOnMaxLength(activity, activity.getEdcpf(),activity.getEddatanascimento(), 14);
        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
        Utils.hideSoftKeyboardOnMaxLength(activity,activity.getEdtelefonecelular(), 13);
        Utils.nextInputOnMaxLength(activity, activity.getEdtelefoneresidencial(),activity.getEdtelefonecelular(), 13);
    }

    public boolean isValidateActivity(){
        boolean nomeError = false;
        boolean cpfError = false;
        boolean dataDeAniverssárioError = false;
        boolean emailError = false;
        boolean nacionalidadeError = false;
        boolean telefoneCelularError = false;
        boolean cepError = false;


        if(activity.getEdnome().getText().toString().isEmpty()){
            activity.getEdnome().setError(activity.getString(R.string.error_invalid));
            activity.getEdnome().requestFocus();
            nomeError = true;
        }


        if(activity.getEddatanascimento().getText().toString().length() < 10){
            activity.getEddatanascimento().setError(activity.getString(R.string.error_data_nascimento_invalida));
            activity.getEddatanascimento().requestFocus();
            dataDeAniverssárioError = true;
        }


        if(activity.getEdnacionalidade().getText().toString().isEmpty()){
            activity.getEdnacionalidade().setError(activity.getString(R.string.error_invalid));
            activity.getEdnacionalidade().requestFocus();
            nacionalidadeError = true;
        }

        if(!ValidationsForms.isCPF(activity.getEdcpf().getText().toString())){
            activity.getEdcpf().setError(activity.getString(R.string.error_invalid_cpf));
            activity.getEdcpf().requestFocus();
            cpfError = true;
        }

        if(activity.getEdcep().getText().toString().length() < 10){
            activity.getEdcep().setError(activity.getString(R.string.cep_error));
            activity.getEdcep().requestFocus();
            cepError = true;
        }else if(activity.getEdcep().getText().toString().isEmpty()){
            activity.getEdcep().setError(activity.getString(R.string.error_invalid));
            activity.getEdcep().requestFocus();
            cepError = true;
        }

        if(activity.getEdtelefonecelular().getText().toString().isEmpty()){
            activity.getEdtelefonecelular().setError(activity.getString(R.string.error_invalid));
            activity.getEdtelefonecelular().requestFocus();
            telefoneCelularError = true;
        }


        if(!ValidationsForms.isEmail(activity.getEdemail().getText().toString())){
            activity.getEdemail().setError(activity.getString(R.string.error_invalid_email));
            activity.getEdemail().requestFocus();
            emailError = true;
        }


        if(nomeError || cpfError || dataDeAniverssárioError ||emailError || nacionalidadeError ||
                cepError ||telefoneCelularError){
            return false;
        }else {
            return true;
        }
    }
}
