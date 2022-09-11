package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Funcionarios extends AppCompatActivity implements View.OnClickListener {

    EditText nome,funcao,genero,nascimento,entrada,salario,kill,codename;
    CheckBox importante;
    AppCompatButton cadastrar,limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

        nome = findViewById(R.id.nome);
        funcao = findViewById(R.id.funcao);
        genero = findViewById(R.id.genero);
        nascimento = findViewById(R.id.nascimento);
        entrada = findViewById(R.id.entrada);
        salario = findViewById(R.id.salario);
        kill = findViewById(R.id.kill);
        codename = findViewById(R.id.codenome);
        importante = findViewById(R.id.importante);
        cadastrar = findViewById(R.id.cadastrar);
        limpar = findViewById(R.id.limpar);

        cadastrar.setOnClickListener(this);
        limpar.setOnClickListener(this);

    }

    void limpa () {
        nome.setText("");
        funcao.setText("");
        genero.setText("");
        nascimento.setText("");
        entrada.setText("");
        salario.setText("");
        kill.setText("");
        codename.setText("");
        importante.setChecked(false);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar) {

            try {

                SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

                banco.execSQL("CREATE TABLE IF NOT EXISTS TB_funcionarios(nome VARCHAR,funcao VARCHAR, genero VARCHAR, datadenascimento VARCHAR,datadeentrada VARCHAR,salario REAL, kill INT, codenome VARCHAR, importante VARCHAR)");

                banco.execSQL("INSERT INTO TB_funcionarios(nome, funcao, genero, datadenascimento, datadeentrada, salario, kill, codenome, importante) VALUES ('" + nome.getText().toString() + "' , " +
                        "'" + funcao.getText().toString() + "' , " +
                        "'" + genero.getText().toString() + "' ," +
                        "'" + nascimento.getText().toString() + "', " +
                        "'" + entrada.getText().toString() + "', " +
                        "'" + Double.parseDouble(salario.getText().toString()) + "', " +
                        "'" + Integer.parseInt(kill.getText().toString()) + "', " +
                        "'" + codename.getText().toString() + "', " +
                        "'" + importante.isChecked() + "') ");

                limpa();

            } catch (Exception e){}





        } else {
            limpa();
        }

    }
}