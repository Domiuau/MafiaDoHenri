package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class PessoasQueDevem extends AppCompatActivity implements View.OnClickListener {

    EditText nome, genero, endereco, tamanhodivida,telefone,datanascimento,devedesde;
    AppCompatButton cadastrar,limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoas_que_devem);

        nome = findViewById(R.id.nome);
        genero = findViewById(R.id.genero);
        endereco = findViewById(R.id.endereco);
        tamanhodivida = findViewById(R.id.tamanhodivida);
        telefone = findViewById(R.id.telefone);
        datanascimento = findViewById(R.id.datanascimento);
        devedesde = findViewById(R.id.devedesde);
        cadastrar = findViewById(R.id.cadastrar);
        limpar = findViewById(R.id.limpar);

        cadastrar.setOnClickListener(this);
        limpar.setOnClickListener(this);

    }

    void limpa () {
        genero.setText("");
        endereco.setText("");
        tamanhodivida.setText("");
        telefone.setText("");
        datanascimento.setText("");
        devedesde.setText("");
        nome.setText("");
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar) {

            try {

                SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

                banco.execSQL("CREATE TABLE IF NOT EXISTS TB_pessoasquedevem(nome VARCHAR,genero VARCHAR, endereco VARCHAR, tamanhodadivida VARCHAR,telefone INT,nascimento VARCHAR, devedesde VARCHAR)");

                banco.execSQL("INSERT INTO TB_pessoasquedevem(nome,genero,endereco,tamanhodadivida,telefone,nascimento,devedesde) VALUES ('" + nome.getText().toString() + "' , " +
                        "'" + genero.getText().toString() + "' , " +
                        "'" + endereco.getText().toString() + "' ," +
                        "'" + tamanhodivida.getText().toString() + "', " +
                        "'" + Integer.parseInt(telefone.getText().toString()) + "', " +
                        "'" + datanascimento.getText().toString() + "', " +
                        "'" + devedesde.getText().toString() + "' )");

                limpa();

            } catch (Exception e){}





        } else {
            limpa();
        }

    }
}