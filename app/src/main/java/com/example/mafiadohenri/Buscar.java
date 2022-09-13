package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class Buscar extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton buscar, exibir, selecionada, tudo1;
    EditText palavra;
    ScrollView mudafundo;
    TextView mostrar;
    Spinner tabelas;
    String tudo = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

        buscar = findViewById(R.id.buscar);
        mostrar = findViewById(R.id.mostra);
        exibir = findViewById(R.id.exibir);
        palavra = findViewById(R.id.palavra);
        tabelas = findViewById(R.id.tabelas);
        tudo1 = findViewById(R.id.tudo);
        mudafundo = findViewById(R.id.mudafundo);
        selecionada = findViewById(R.id.selecionada);

        exibir.setOnClickListener(this);
        buscar.setOnClickListener(this);
        tudo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                banco.execSQL("DELETE FROM TB_contratos");
                banco.execSQL("DELETE FROM TB_funcionarios");
                banco.execSQL("DELETE FROM TB_mercadorias");
                banco.execSQL("DELETE FROM TB_inimigos");
                banco.execSQL("DELETE FROM TB_pessoasquedevem");
                banco.execSQL("DELETE FROM TB_territorios");
                palavra.setText("");
                mostrar.setText("");
                mudafundo.setBackgroundResource(R.drawable.fundo);
                mostrar.setBackgroundResource(R.drawable.fundo);
                Toast.makeText(Buscar.this, "Banco de dados limpo com sucesso!", Toast.LENGTH_SHORT).show();


            }
        });

        selecionada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                palavra.setText("");
                mostrar.setText("");
                mudafundo.setBackgroundResource(R.drawable.fundo);
                mostrar.setBackgroundResource(R.drawable.fundo);

                switch (tabelas.getSelectedItemPosition()){
                    case 0:
                        banco.execSQL("DELETE FROM TB_pessoasquedevem");
                        break;

                    case 1:
                        banco.execSQL("DELETE FROM TB_funcionarios");
                        break;

                    case 2:
                        banco.execSQL("DELETE FROM TB_inimigos");
                        break;

                    case 3:
                        banco.execSQL("DELETE FROM TB_mercadorias");
                        break;

                    case 4:
                        banco.execSQL("DELETE FROM TB_territorios");
                        break;

                    case 5:
                        banco.execSQL("DELETE FROM TB_contratos");
                        break;
                }

                Toast.makeText(Buscar.this, "Tabela limpa com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public void onClick(View v) {

        mudafundo.setBackgroundResource(R.drawable.fundo2);
        mostrar.setBackgroundResource(R.drawable.fundo2);

        tudo = "";

        switch (tabelas.getSelectedItemPosition()) {

            case 0:
                try {

                    SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);
                    String consulta;

                    if (v.getId() == R.id.exibir) {
                        consulta = "SELECT nome,genero,endereco,tamanhodadivida,telefone,nascimento,devedesde FROM TB_pessoasquedevem";
                    } else {
                        consulta = "SELECT nome,genero,endereco,tamanhodadivida,telefone,nascimento,devedesde FROM TB_pessoasquedevem" +
                                " WHERE nome LIKE '" + palavra.getText().toString() + "' " +
                                "OR genero LIKE '" + palavra.getText().toString() + "' " +
                                "OR endereco LIKE '" + palavra.getText().toString() + "' " +
                                "OR tamanhodadivida LIKE '" + palavra.getText().toString() + "' " +
                                "OR nascimento LIKE '" + palavra.getText().toString() + "' " +
                                "OR devedesde LIKE '" + palavra.getText().toString() + "'";
                    }

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int[] icoisas = {cursor.getColumnIndex("nome"),
                            cursor.getColumnIndex("genero"),
                            cursor.getColumnIndex("endereco"),
                            cursor.getColumnIndex("tamanhodadivida"),
                            cursor.getColumnIndex("telefone"),
                            cursor.getColumnIndex("nascimento"),
                            cursor.getColumnIndex("devedesde")
                    };

                    while (cursor != null) {

                        String[] a = {
                                cursor.getString(icoisas[0]),
                                cursor.getString(icoisas[1]),
                                cursor.getString(icoisas[2]),
                                cursor.getString(icoisas[3]),
                                cursor.getString(icoisas[4]),
                                cursor.getString(icoisas[5]),
                                cursor.getString(icoisas[6])


                        };

                        cursor.moveToNext();

                        tudo += "Nome: " + a[0] + "\n" +
                                "Gênero: " + a[1] + "\n" +
                                "Endereço: " + a[2] + "\n" +
                                "Tamanho da dívida: " + a[3] + "\n" +
                                "Telefone: " + a[4] + "\n" +
                                "Nascimento: " + a[5] + "\n" +
                                "Deve desde: " + a[6] + "\n" + "\n";

                        mostrar.setText(tudo);

                    }

                } catch (Exception e) {
                }

                break;

            case 1:
                try {

                    SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);
                    String consulta;

                    if (v.getId() == R.id.exibir) {
                        consulta = "SELECT nome, funcao, genero, datadenascimento, datadeentrada, salario, kill, codenome, importante FROM TB_funcionarios";
                    } else {
                        consulta = "SELECT nome, funcao, genero, datadenascimento, datadeentrada, salario, kill, codenome, importante FROM TB_funcionarios" +
                                " WHERE nome LIKE '" + palavra.getText().toString() + "' " +
                                "OR funcao LIKE '" + palavra.getText().toString() + "' " +
                                "OR genero LIKE '" + palavra.getText().toString() + "' " +
                                "OR datadenascimento LIKE '" + palavra.getText().toString() + "' " +
                                "OR datadeentrada LIKE '" + palavra.getText().toString() + "' " +
                                "OR salario LIKE '" + palavra.getText().toString() + "' " +
                                "OR kill LIKE '" + palavra.getText().toString() + "' " +
                                "OR codenome LIKE '" + palavra.getText().toString() + "' " +
                                "OR importante LIKE '" + palavra.getText().toString() + "' ";
                    }

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int[] icoisas = {cursor.getColumnIndex("nome"),
                            cursor.getColumnIndex("funcao"),
                            cursor.getColumnIndex("genero"),
                            cursor.getColumnIndex("datadenascimento"),
                            cursor.getColumnIndex("datadeentrada"),
                            cursor.getColumnIndex("salario"),
                            cursor.getColumnIndex("kill"),
                            cursor.getColumnIndex("codenome"),
                            cursor.getColumnIndex("importante")
                    };

                    while (cursor != null) {

                        String[] a = {
                                cursor.getString(icoisas[0]),
                                cursor.getString(icoisas[1]),
                                cursor.getString(icoisas[2]),
                                cursor.getString(icoisas[3]),
                                cursor.getString(icoisas[4]),
                                cursor.getString(icoisas[5]),
                                cursor.getString(icoisas[6]),
                                cursor.getString(icoisas[7]),
                                cursor.getString(icoisas[8])


                        };

                        cursor.moveToNext();

                        tudo += "Nome: " + a[0] + "\n" +
                                "Função: " + a[1] + "\n" +
                                "Gênero: " + a[2] + "\n" +
                                "Data de nascimento: " + a[3] + "\n" +
                                "Data de entrada: " + a[4] + "\n" +
                                "Salário: " + a[5] + "\n" +
                                "KillCount: " + a[6] + "\n" +
                                "Codename: " + a[7] + "\n" +
                                "Importante: " + a[8] + "\n" + "\n";

                        mostrar.setText(tudo);

                    }

                } catch (Exception e) {
                }
                break;

            case 2:

                try {

                    SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);
                    String consulta;

                    if (v.getId() == R.id.exibir) {
                        consulta = "SELECT nome,regiao, nomelider, prioridade,motivo,ameaca, infiltrados FROM TB_inimigos";
                    } else {
                        consulta = "SELECT nome,regiao, nomelider, prioridade,motivo,ameaca, infiltrados FROM TB_inimigos" +
                                " WHERE nome LIKE '" + palavra.getText().toString() + "' " +
                                "OR regiao LIKE '" + palavra.getText().toString() + "' " +
                                "OR nomelider LIKE '" + palavra.getText().toString() + "' " +
                                "OR prioridade LIKE '" + palavra.getText().toString() + "' " +
                                "OR motivo LIKE '" + palavra.getText().toString() + "' " +
                                "OR ameaca LIKE '" + palavra.getText().toString() + "' " +
                                "OR infiltrados LIKE '" + palavra.getText().toString() + "' ";
                    }

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int[] icoisas = {cursor.getColumnIndex("nome"),
                            cursor.getColumnIndex("regiao"),
                            cursor.getColumnIndex("nomelider"),
                            cursor.getColumnIndex("prioridade"),
                            cursor.getColumnIndex("motivo"),
                            cursor.getColumnIndex("ameaca"),
                            cursor.getColumnIndex("infiltrados")
                    };

                    while (cursor != null) {

                        String[] a = {
                                cursor.getString(icoisas[0]),
                                cursor.getString(icoisas[1]),
                                cursor.getString(icoisas[2]),
                                cursor.getString(icoisas[3]),
                                cursor.getString(icoisas[4]),
                                cursor.getString(icoisas[5]),
                                cursor.getString(icoisas[6])


                        };

                        cursor.moveToNext();

                        tudo += "Nome: " + a[0] + "\n" +
                                "Região: " + a[1] + "\n" +
                                "Nome do líder: " + a[2] + "\n" +
                                "Prioridade: " + a[3] + "\n" +
                                "Motivo: " + a[4] + "\n" +
                                "Ameaça: " + a[5] + "\n" +
                                "Temos infiltrados: " + a[6] + "\n" + "\n";

                        mostrar.setText(tudo);

                    }

                } catch (Exception e) {
                }
                break;

            case 3:
                try {

                    SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);
                    String consulta;

                    if (v.getId() == R.id.exibir) {
                        consulta = "SELECT tipomercadoria,nomemercadoria, preco, localvenda,lucro,emestoque, quemvende, legal FROM TB_mercadorias";
                    } else {
                        consulta = "SELECT tipomercadoria,nomemercadoria, preco, localvenda,lucro,emestoque, quemvende, legal FROM TB_mercadorias" +
                                " WHERE tipomercadoria LIKE '" + palavra.getText().toString() + "' " +
                                "OR nomemercadoria LIKE '" + palavra.getText().toString() + "' " +
                                "OR preco LIKE '" + palavra.getText().toString() + "' " +
                                "OR localvenda LIKE '" + palavra.getText().toString() + "' " +
                                "OR lucro LIKE '" + palavra.getText().toString() + "' " +
                                "OR emestoque LIKE '" + palavra.getText().toString() + "' " +
                                "OR quemvende LIKE '" + palavra.getText().toString() + "' " +
                                "OR legal LIKE '" + palavra.getText().toString() + "'";
                    }

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int[] icoisas = {cursor.getColumnIndex("tipomercadoria"),
                            cursor.getColumnIndex("nomemercadoria"),
                            cursor.getColumnIndex("preco"),
                            cursor.getColumnIndex("localvenda"),
                            cursor.getColumnIndex("lucro"),
                            cursor.getColumnIndex("emestoque"),
                            cursor.getColumnIndex("quemvende"),
                            cursor.getColumnIndex("legal")
                    };

                    while (cursor != null) {

                        String[] a = {
                                cursor.getString(icoisas[0]),
                                cursor.getString(icoisas[1]),
                                cursor.getString(icoisas[2]),
                                cursor.getString(icoisas[3]),
                                cursor.getString(icoisas[4]),
                                cursor.getString(icoisas[5]),
                                cursor.getString(icoisas[6]),
                                cursor.getString(icoisas[7])

                        };

                        cursor.moveToNext();

                        tudo += "Tipo de mercadoria: " + a[0] + "\n" +
                                "Nome da mercadoria: " + a[1] + "\n" +
                                "Preço: " + a[2] + "\n" +
                                "Local de venda: " + a[3] + "\n" +
                                "Lucro: " + a[4] + "\n" +
                                "Em estoque: " + a[5] + "\n" +
                                "Quem vende: " + a[6] + "\n" +
                                "Legal: " + a[7] + "\n" + "\n";

                        mostrar.setText(tudo);

                    }

                } catch (Exception e) {
                }
                break;

            case 4:
                try {

                    SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);
                    String consulta;

                    if (v.getId() == R.id.exibir) {
                        consulta = "SELECT local,importantepara, dominado, quemdomina,emconflito FROM TB_territorios";
                    } else {
                        consulta = "SELECT local,importantepara, dominado, quemdomina,emconflito FROM TB_territorios" +
                                " WHERE local LIKE '" + palavra.getText().toString() + "' " +
                                "OR importantepara LIKE '" + palavra.getText().toString() + "' " +
                                "OR dominado LIKE '" + palavra.getText().toString() + "' " +
                                "OR quemdomina LIKE '" + palavra.getText().toString() + "' " +
                                "OR emconflito LIKE '" + palavra.getText().toString() + "'";
                    }

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int[] icoisas = {cursor.getColumnIndex("local"),
                            cursor.getColumnIndex("importantepara"),
                            cursor.getColumnIndex("dominado"),
                            cursor.getColumnIndex("quemdomina"),
                            cursor.getColumnIndex("emconflito")
                    };

                    while (cursor != null) {

                        String[] a = {
                                cursor.getString(icoisas[0]),
                                cursor.getString(icoisas[1]),
                                cursor.getString(icoisas[2]),
                                cursor.getString(icoisas[3]),
                                cursor.getString(icoisas[4])


                        };

                        cursor.moveToNext();

                        tudo += "Local: " + a[0] + "\n" +
                                "Importante para: " + a[1] + "\n" +
                                "Está dominado: " + a[2] + "\n" +
                                "Quem domina: " + a[3] + "\n" +
                                "Está em conflito: " + a[4] + "\n" + "\n";

                        mostrar.setText(tudo);

                    }

                } catch (Exception e) {
                }
                break;

            case 5:

                try {

                    SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);
                    String consulta;

                    if (v.getId() == R.id.exibir) {
                        consulta = "SELECT tipo,pessoaquecontratou,inicio,fim,preco,detalhes,arriscado FROM TB_contratos";
                    } else {
                        consulta = "SELECT tipo,pessoaquecontratou,inicio,fim,preco,detalhes,arriscado FROM TB_contratos" +
                                " WHERE tipo LIKE '" + palavra.getText().toString() + "' " +
                                "OR pessoaquecontratou LIKE '" + palavra.getText().toString() + "' " +
                                "OR inicio LIKE '" + palavra.getText().toString() + "' " +
                                "OR fim LIKE '" + palavra.getText().toString() + "' " +
                                "OR preco LIKE '" + palavra.getText().toString() + "' " +
                                "OR detalhes LIKE '" + palavra.getText().toString() + "' " +
                                "OR arriscado LIKE '" + palavra.getText().toString() + "'";
                    }

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int[] icoisas = {cursor.getColumnIndex("tipo"),
                            cursor.getColumnIndex("pessoaquecontratou"),
                            cursor.getColumnIndex("inicio"),
                            cursor.getColumnIndex("fim"),
                            cursor.getColumnIndex("preco"),
                            cursor.getColumnIndex("detalhes"),
                            cursor.getColumnIndex("arriscado")
                    };

                    while (cursor != null) {

                        String[] a = {
                                cursor.getString(icoisas[0]),
                                cursor.getString(icoisas[1]),
                                cursor.getString(icoisas[2]),
                                cursor.getString(icoisas[3]),
                                cursor.getString(icoisas[4]),
                                cursor.getString(icoisas[5]),
                                cursor.getString(icoisas[6])


                        };

                        cursor.moveToNext();

                        tudo += "Tipo de serviço: " + a[0] + "\n" +
                                "Pessoa que contratou: " + a[1] + "\n" +
                                "Inicio do contrato: " + a[2] + "\n" +
                                "Fim do contrato: " + a[3] + "\n" +
                                "Preço cobrado: " + a[4] + "\n" +
                                "Detalhes sobre o contrato: " + a[5] + "\n" +
                                "Arriscado: " + a[6] + "\n" + "\n";

                        mostrar.setText(tudo);

                    }

                } catch (Exception e) {
                }

                break;


        }

                if (mostrar.getText().toString().isEmpty()){

                    mostrar.setBackgroundResource(R.drawable.fundo);
                    mudafundo.setBackgroundResource(R.drawable.fundo);
                }
                if (v.getId() == R.id.buscar && palavra.getText().toString().isEmpty()){
                    mostrar.setText("");
                    mostrar.setBackgroundResource(R.drawable.fundo);
                    mudafundo.setBackgroundResource(R.drawable.fundo);
                }

    }

}
