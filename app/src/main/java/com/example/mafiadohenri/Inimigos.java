package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class Inimigos extends AppCompatActivity implements View.OnClickListener {

    EditText nomefaccao, regiao, nomelider, motivo;
    Spinner prioridade;
    CheckBox ameaca, infiltrados;
    AppCompatButton cadastrar, limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inimigos);

        nomefaccao = findViewById(R.id.nomefaccao);
        regiao = findViewById(R.id.regiao);
        nomelider = findViewById(R.id.nomelider);
        motivo = findViewById(R.id.motivo);
        prioridade = findViewById(R.id.prioridade);
        ameaca = findViewById(R.id.ameaca);
        infiltrados = findViewById(R.id.infiltrados);
        cadastrar = findViewById(R.id.cadastrar);
        limpar = findViewById(R.id.limpar);

        cadastrar.setOnClickListener(this);
        limpar.setOnClickListener(this);


    }

    void limpa() {
        nomefaccao.setText("");
        regiao.setText("");
        nomelider.setText("");
        prioridade.setSelection(0);
        motivo.setText("");
        ameaca.setChecked(false);
        infiltrados.setChecked(false);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar) {

            try {

                SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

                banco.execSQL("CREATE TABLE IF NOT EXISTS TB_inimigos(nome VARCHAR,regiao VARCHAR, nomelider VARCHAR, prioridade VARCHAR,motivo VARCHAR,ameaca VARCHAR, infiltrados VARCHAR)");

                banco.execSQL("INSERT INTO TB_inimigos(nome,regiao, nomelider, prioridade,motivo,ameaca, infiltrados) VALUES ('" + nomefaccao.getText().toString() + "' , " +
                        "'" + regiao.getText().toString() + "' , " +
                        "'" + nomelider.getText().toString() + "' ," +
                        "'" + prioridade.getSelectedItem().toString() + "', " +
                        "'" + motivo.getText().toString() + "', " +
                        "'" + ameaca.isChecked() + "', " +
                        "'" + infiltrados.isChecked() + "') ");

                limpa();

            } catch (Exception e) {
            }


        } else {
            limpa();
        }

    }
}