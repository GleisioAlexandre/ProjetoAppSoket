package com.varela.gleisio.projetoappsoket.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.varela.gleisio.projetoappsoket.model.ClassDadosConexao;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class CalssOperacao {
    private String teste ;
    private String resposta;
    ClassDadosConexao cx = new ClassDadosConexao();

    public void Conexao(String host, int porta) {

        cx.setHost(host);
        cx.setPorta(porta);
        cx.setDataOut("(&A)");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Socket sk = new Socket(cx.getHost(), cx.getPorta());

                    OutputStream fluxoDeSaida = sk.getOutputStream();

                    fluxoDeSaida.write(cx.getDataOut().getBytes());

                    InputStream fluxoDeEntrada = sk.getInputStream();

                    byte[] buffer = new byte[1024];
                    int bytesRead = fluxoDeEntrada.read(buffer);
                    resposta = new String(buffer, 0, bytesRead);
                    teste = resposta;
                    if (teste.equals("0") == false){
                        fluxoDeSaida.write("(&I)".getBytes());
                    }
                    sk.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        thread.start();

        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        synchronized (this){
           cx.setDataIn(teste);

        }
    }
    public String resposta(){
        cx.resultado();

        return cx.getDataIn();
    }


}
