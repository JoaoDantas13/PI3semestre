package com.mycompany.lojapereirao.model;

//nome do projeto
public class Venda {
    
 
//Atributos
    
    private int codVenda;
    private int codCli;
    private int codProd;
    private int qtdProd;
    private double valorUnt;
    private double valorTotal;
        
//Construtor
    
public Venda (){
    
}

//Metodos acessores

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public double getValorUnt() {
        return valorUnt;
    }

    public void setValorUnt(double valorUnt) {
        this.valorUnt = valorUnt;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
