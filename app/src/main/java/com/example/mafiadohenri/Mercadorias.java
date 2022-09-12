package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Mercadorias extends AppCompatActivity implements View.OnClickListener {

    EditText tipomercadoria, nomemercadoria, preco, localdevenda,lucro,quantidade,quemvende;
    CheckBox legal;
    AppCompatButton cadastrar,limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercadorias);

        tipomercadoria = findViewById(R.id.tipomercadoria);
        nomemercadoria = findViewById(R.id.nomemercadoria);
        preco = findViewById(R.id.preco);
        localdevenda = findViewById(R.id.localdevenda);
        lucro = findViewById(R.id.lucro);
        quantidade = findViewById(R.id.quantidade);
        quemvende = findViewById(R.id.quemvende);
        legal = findViewById(R.id.legal);
        cadastrar = findViewById(R.id.cadastrar);
        limpar = findViewById(R.id.limpar);

        cadastrar.setOnClickListener(this);
        limpar.setOnClickListener(this);
    }

    void limpa (){
        tipomercadoria.setText("");
        nomemercadoria.setText("");
        preco.setText("");
        localdevenda.setText("");
        lucro.setText("");
        quemvende.setText("");
        quantidade.setText("");
        legal.setChecked(false);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar) {

            try {

                SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

                banco.execSQL("CREATE TABLE IF NOT EXISTS TB_mercadorias(tipomercadoria VARCHAR,nomemercadoria VARCHAR, preco REAL, localvenda VARCHAR,lucro REAL,emestoque INT, quemvende VARCHAR, legal VARCHAR)");

                banco.execSQL("INSERT INTO TB_mercadorias(tipomercadoria,nomemercadoria, preco, localvenda,lucro,emestoque, quemvende, legal) VALUES ('" + tipomercadoria.getText().toString() + "' , " +
                        "'" + nomemercadoria.getText().toString() + "' , " +
                        "'" + Double.parseDouble(preco.getText().toString()) + "' ," +
                        "'" + localdevenda.getText().toString() + "', " +
                        "'" + Double.parseDouble(lucro.getText().toString()) + "', " +
                        "'" + Integer.parseInt(quantidade.getText().toString()) + "', " +
                        "'" + quemvende.getText().toString() + "', " +
                        "'" + legal.isChecked() + "') ");

                limpa();
                Toast.makeText(Mercadorias.this, "Registrado com sucesso!", Toast.LENGTH_SHORT).show();

            } catch (Exception e){
                Toast.makeText(Mercadorias.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }





        } else {
            limpa();
        }

    }
}