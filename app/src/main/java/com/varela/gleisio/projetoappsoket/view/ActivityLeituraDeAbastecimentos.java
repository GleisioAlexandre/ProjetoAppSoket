package com.varela.gleisio.projetoappsoket.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.varela.gleisio.projetoappsoket.R;
import com.varela.gleisio.projetoappsoket.controller.CalssOperacao;

public class ActivityLeituraDeAbastecimentos extends AppCompatActivity {

    public EditText host;
    public EditText porta;
    public TextView txtResultado;
    public Button btnTransmicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        host = findViewById(R.id.txtHost);
        porta = findViewById(R.id.txtPorta);
        txtResultado = findViewById(R.id.txtResultado);
        btnTransmicao = findViewById(R.id.btnTransmicao);

        btnTransmicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CalssOperacao op = new CalssOperacao();
                op.Conexao(host.getText().toString(), Integer.parseInt(porta.getText().toString()));


               txtResultado.setText(op.resposta().replace("(", "").replace(")", ""));
            }
        });

    }
}