package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton cadastro,buscar,sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cadastro = findViewById(R.id.cadastrar);
        buscar = findViewById(R.id.buscar);
        sair = findViewById(R.id.sair);

        cadastro.setOnClickListener(this);
        buscar.setOnClickListener(this);
        sair.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar){
            Intent troca = new Intent(this,Escolhercadastro.class);
            startActivity(troca);

        } else if (v.getId() == R.id.buscar){
            Intent troca = new Intent(this,Buscar.class);
            startActivity(troca);

        } else {
            System.exit(0);

        }

    }
}