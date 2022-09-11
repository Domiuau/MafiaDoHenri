package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class Tabelasexebidas extends AppCompatActivity {
    TextView tabela,tudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabelasexebidas);

        tabela = findViewById(R.id.tabela);
        tudo = findViewById(R.id.tudo);


    }




}