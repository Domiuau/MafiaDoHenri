package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Escolhercadastro extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton pessoasquedevem, funcionarios, inimigos, mercadorias, territorios, contrato;
    AppCompatImageButton gerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhercadastro);

        pessoasquedevem = findViewById(R.id.pessoasquedevem);
        funcionarios = findViewById(R.id.funcionarios);
        inimigos = findViewById(R.id.inimigos);
        mercadorias = findViewById(R.id.mercadorias);
        territorios = findViewById(R.id.territorios);
        contrato = findViewById(R.id.contrato);
        gerar = findViewById(R.id.gerar);

        pessoasquedevem.setOnClickListener(this);
        funcionarios.setOnClickListener(this);
        inimigos.setOnClickListener(this);
        mercadorias.setOnClickListener(this);
        territorios.setOnClickListener(this);
        contrato.setOnClickListener(this);
        gerar.setOnClickListener(this);


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

            case R.id.gerar:

                try {


                    for (int i = 0; i < 10; ++i) {

                        SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

                        banco.execSQL("CREATE TABLE IF NOT EXISTS TB_contratos(tipo VARCHAR,pessoaquecontratou VARCHAR, inicio VARCHAR, fim VARCHAR,preco REAL,detalhes VARCHAR, arriscado VARCHAR)");
                        banco.execSQL("INSERT INTO TB_contratos(tipo,pessoaquecontratou,inicio,fim,preco,detalhes,arriscado) VALUES ('Espionagem' , " +
                                "'Henri' , " +
                                "'05/06/2019' ," +
                                "'10/08/2022', " +
                                "706, " +
                                "'Precisamos espionar o perazzelli para denunciar seus crimes de guerra', " +
                                "'true' )");

                        banco.execSQL("CREATE TABLE IF NOT EXISTS TB_funcionarios(nome VARCHAR,funcao VARCHAR, genero VARCHAR, datadenascimento VARCHAR,datadeentrada VARCHAR,salario REAL, kill INT, codenome VARCHAR, importante VARCHAR)");
                        banco.execSQL("INSERT INTO TB_funcionarios(nome, funcao, genero, datadenascimento, datadeentrada, salario, kill, codenome, importante) VALUES ('Hominho' , " +
                                "'Furtar pessoas em osasco' , " +
                                "'feminino' ," +
                                "'65/45/9999', " +
                                "'04/05/2000', " +
                                "'10', " +
                                "'0', " +
                                "'homao', " +
                                "'true') ");

                        banco.execSQL("CREATE TABLE IF NOT EXISTS TB_inimigos(nome VARCHAR,regiao VARCHAR, nomelider VARCHAR, prioridade VARCHAR,motivo VARCHAR,ameaca VARCHAR, infiltrados VARCHAR)");
                        banco.execSQL("INSERT INTO TB_inimigos(nome,regiao, nomelider, prioridade,motivo,ameaca, infiltrados) VALUES ('perazzelli' , " +
                                "'perazzelli' , " +
                                "'perazzelli' ," +
                                "'alta', " +
                                "'perazzelli', " +
                                "'perazzelli', " +
                                "'perazzelli') ");


                        banco.execSQL("CREATE TABLE IF NOT EXISTS TB_mercadorias(tipomercadoria VARCHAR,nomemercadoria VARCHAR, preco REAL, localvenda VARCHAR,lucro REAL,emestoque INT, quemvende VARCHAR, legal VARCHAR)");
                        banco.execSQL("INSERT INTO TB_mercadorias(tipomercadoria,nomemercadoria, preco, localvenda,lucro,emestoque, quemvende, legal) VALUES ('carros' , " +
                                "'carroamarelo' , " +
                                "'5535.5545' ," +
                                "'amarelo', " +
                                "'50.7', " +
                                "'3', " +
                                "'carroazul', " +
                                "'Não') ");

                        banco.execSQL("CREATE TABLE IF NOT EXISTS TB_pessoasquedevem(nome VARCHAR,genero VARCHAR, endereco VARCHAR, tamanhodadivida VARCHAR,telefone INT,nascimento VARCHAR, devedesde VARCHAR)");
                        banco.execSQL("INSERT INTO TB_pessoasquedevem(nome,genero,endereco,tamanhodadivida,telefone,nascimento,devedesde) VALUES ('roberto' , " +
                                "'macho alfa' , " +
                                "'dust 2' ," +
                                "'5', " +
                                "'9 123456789', " +
                                "'20/04/1405', " +
                                "'20/04/1405' )");

                        banco.execSQL("CREATE TABLE IF NOT EXISTS TB_territorios(local VARCHAR,importantepara VARCHAR, dominado VARCHAR, quemdomina VARCHAR,emconflito VARCHAR)");
                        banco.execSQL("INSERT INTO TB_territorios(local,importantepara, dominado, quemdomina,emconflito) VALUES ('morrinho' , " +
                                "'jogar frisbee' , " +
                                "'true' ," +
                                "'muitas pessoas', " +
                                "'true') ");


                    }

                    Toast.makeText(Escolhercadastro.this, "10 registros foram gerados!", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                }


        }
    }

}
