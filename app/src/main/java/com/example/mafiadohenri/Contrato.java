package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Contrato extends AppCompatActivity implements View.OnClickListener {

    EditText tipo, pessoaquecontratou, inicio, fim, preco, detalhes;
    AppCompatButton cadastrar, limpar;
    CheckBox arriscado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);

        tipo = findViewById(R.id.tipo);
        pessoaquecontratou = findViewById(R.id.pessoaquecontratou);
        inicio = findViewById(R.id.inicio);
        fim = findViewById(R.id.fim);
        arriscado = findViewById(R.id.arriscado);
        preco = findViewById(R.id.preco);
        detalhes = findViewById(R.id.detalhes);
        cadastrar = findViewById(R.id.cadastrar);
        limpar = findViewById(R.id.limpar);

        cadastrar.setOnClickListener(this);
        limpar.setOnClickListener(this);


    }

    void limpa() {
        tipo.setText("");
        pessoaquecontratou.setText("");
        inicio.setText("");
        fim.setText("");
        arriscado.setChecked(false);
        preco.setText("");
        detalhes.setText("");
        tipo.setText("");
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar) {

            try {

                SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

                banco.execSQL("CREATE TABLE IF NOT EXISTS TB_contratos(tipo VARCHAR,pessoaquecontratou VARCHAR, inicio VARCHAR, fim VARCHAR,preco REAL,detalhes VARCHAR, arriscado VARCHAR)");

                banco.execSQL("INSERT INTO TB_contratos(tipo,pessoaquecontratou,inicio,fim,preco,detalhes,arriscado) VALUES ('" + tipo.getText().toString() + "' , " +
                        "'" + pessoaquecontratou.getText().toString() + "' , " +
                        "'" + inicio.getText().toString() + "' ," +
                        "'" + fim.getText().toString() + "', " +
                        "'" + Double.parseDouble(preco.getText().toString()) + "', " +
                        "'" + detalhes.getText().toString() + "', " +
                        "'" + arriscado.isChecked() + "' )");

                limpa();
                Toast.makeText(Contrato.this,"Registrado com sucesso!", Toast.LENGTH_SHORT).show();

            } catch (Exception e){
                Toast.makeText(Contrato.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }





        } else {
            limpa();
        }


    }
}