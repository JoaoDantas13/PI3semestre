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
 * @author Eduardo Silva
 */

@Getter
@Setter
public class Produto extends SuperProduto{
    private String marca;
    private String modelo;
    private String tipo;        
    private int loja;
    private String status;
    
    public Produto(String placa, String marca, String modelo, String tipo, int quantidade, double precoUnit, int loja, String status) {
        super(placa, quantidade, precoUnit);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.loja = loja;
        this.status = status;
    }
    
    
    public boolean validarPrecoUnit() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s <br/> Marca: %s <br/> Modelo: %s <br/> Tipo: %s <br/>"
                + "Loja: %d <br/> Status: %s", 
                super.toString(),marca,modelo,tipo,loja,status);
    }
}
