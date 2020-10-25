package com.mycompany.lojapereirao;

//nome do projeto
public class Venda {
    
 
//Atributos
    
    private static int codVenda;
    private int codVendedor;
    private int codCli;
    private int codProd;
    private int qtdProd;
        
//Construtor
    
public Venda (){
    
}

//Metodos acessores

    public static int getCodVenda() {
        return codVenda;
    }

    public static void setCodVenda(int codVenda) {
        Venda.codVenda = codVenda;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
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

    
}
