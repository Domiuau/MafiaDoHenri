package com.example.mafiadohenri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Territorios extends AppCompatActivity implements View.OnClickListener {

    EditText local,importantepara,quemdomina;
    CheckBox dominado, emconflito;
    AppCompatButton cadastrar,limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_territorios);

        local = findViewById(R.id.local);
        importantepara = findViewById(R.id.importantepara);
        quemdomina = findViewById(R.id.quemdomina);
        dominado = findViewById(R.id.dominado);
        emconflito = findViewById(R.id.emconflito);
        cadastrar = findViewById(R.id.cadastrar);
        limpar = findViewById(R.id.limpar);

        cadastrar.setOnClickListener(this);
        limpar.setOnClickListener(this);




    }

    void limpa () {

        local.setText("");
        importantepara.setText("");
        dominado.setChecked(false);
        quemdomina.setText("");
        emconflito.setChecked(false);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cadastrar) {

        try {

            SQLiteDatabase banco = openOrCreateDatabase("DB_mafia", MODE_PRIVATE, null);

            banco.execSQL("CREATE TABLE IF NOT EXISTS TB_territorios(local VARCHAR,importantepara VARCHAR, dominado VARCHAR, quemdomina VARCHAR,emconflito VARCHAR)");

            banco.execSQL("INSERT INTO TB_territorios(local,importantepara, dominado, quemdomina,emconflito) VALUES ('" + local.getText().toString() + "' , " +
                    "'" + importantepara.getText().toString() + "' , " +
                    "'" + dominado.isChecked() + "' ," +
                    "'" + quemdomina.getText().toString() + "', " +
                    "'" + emconflito.isChecked() + "') ");

            limpa();

        } catch (Exception e){}





    } else {
        limpa();
    }



    }
}