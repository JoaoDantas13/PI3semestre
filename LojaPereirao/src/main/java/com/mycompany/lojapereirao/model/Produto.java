package com.mycompany.lojapereirao.model;

//nome do projeto
public class Produto {
    
//Atributos

    private int codProd;
    private String nome;
    private int qtdCaixa;
    private String undMedida;
    private int saldo;
    private double valor;
    
//Construtor
    
public Produto (){
    
}

//Metodos acessores

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCaixa() {
        return qtdCaixa;
    }

    public void setQtdCaixa(int qtdCaixa) {
        this.qtdCaixa = qtdCaixa;
    }

    public String getUndMedida() {
        return undMedida;
    }

    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    
}
