package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Escolhercadastro extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton pessoasquedevem, funcionarios, inimigos, mercadorias, territorios, contrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhercadastro);
        getWindow().setStatusBarColor(ContextCompat.getColor(Escolhercadastro.this,R.color.naosei));

        pessoasquedevem = findViewById(R.id.pessoasquedevem);
        funcionarios = findViewById(R.id.funcionarios);
        inimigos = findViewById(R.id.inimigos);
        mercadorias = findViewById(R.id.mercadorias);
        territorios = findViewById(R.id.territorios);
        contrato = findViewById(R.id.contrato);

        pessoasquedevem.setOnClickListener(this);
        funcionarios.setOnClickListener(this);
        inimigos.setOnClickListener(this);
        mercadorias.setOnClickListener(this);
        territorios.setOnClickListener(this);
        contrato.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.pessoasquedevem:
                Intent troca1 = new Intent(this, PessoasQueDevem.class);
                startActivity(troca1);
                break;

            case R.id.funcionarios:
                Intent troca2 = new Intent(this, Funcionarios.class);
                startActivity(troca2);
                break;

            case R.id.inimigos:
                Intent troca3 = new Intent(this, Inimigos.class);
                startActivity(troca3);
                break;

            case R.id.mercadorias:
                Intent troca4 = new Intent(this, Mercadorias.class);
                startActivity(troca4);
                break;

            case R.id.territorios:
                Intent troca5 = new Intent(this, Territorios.class);
                startActivity(troca5);
                break;

            case R.id.contrato:
                Intent troca6 = new Intent(this, Contrato.class);
                startActivity(troca6);
                break;


        }

    }
}