package com.mycompany.lojapereirao;

//nome do projeto
public class Produto {
    
//Atributos

    private static int codProd;
    private String nome;
    private int qtdCaixa;
    private String undMedida;
    private int saldo;
    
//Construtor
    
public Produto (){
    
}

//Metodos acessores

    public static int getCodProd() {
        return codProd;
    }

    public static void setCodProd(int codProd) {
        Produto.codProd = codProd;
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


    
}
