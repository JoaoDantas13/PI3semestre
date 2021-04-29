/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.entidade;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Danta
 */

@Getter
@Setter
    public class Vendas {
    private int  CodProd;
    private int CodCliente;
    private String Produto;
    private int Quantidade;
    private int ValorTotal;
    
    public Vendas(int CodProd, int CodCliente, String Produto , int Quantidade , int ValorTotal) {
        this.CodProd = CodProd;
        this.Produto = Produto;
        this.Quantidade = Quantidade;
        this.ValorTotal = ValorTotal;
    }
    
    @Override
    public String toString(){
        return String.format("CodProd: %d <br/> CodCliente: %d <br/> Produto: %s  <br/> "
                + "           Quantidade %d</br> ValorTotal %d", 
                CodProd, CodCliente , Produto ,Quantidade,ValorTotal);
    }

    public String getcodprod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getcodcliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getproduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getquantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getvalortotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Vendas vendas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
