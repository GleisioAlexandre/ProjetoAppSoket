package com.varela.gleisio.projetoappsoket.model;

public class ClassDadosConexao {
    private String host;
    private int porta;
    private String dataIn;
    private String dataOut;

    public void resultado(){
        System.out.println("IP: " + getHost() + "\nPorta: " + getPorta() + "\nDados de Saida: " + getDataOut() + "\nDados de Entrada: " + getDataIn());
    }
    public ClassDadosConexao() {
    }

    public ClassDadosConexao(String host, int porta, String dataIn, String dataOut) {
        this.host = host;
        this.porta = porta;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getDataIn() {
        return dataIn;
    }

    public void setDataIn(String dataIn) {
        this.dataIn = dataIn;
    }

    public String getDataOut() {
        return dataOut;
    }

    public void setDataOut(String dataOut) {
        this.dataOut = dataOut;
    }
}
