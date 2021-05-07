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
public class Produto {
    private String placa;
    private String nome;
    private int quantidade;
    private double precoUnit;
    private int loja;
    private String status;
    
    public Produto(String placa, String nome, int quantidade, double precoUnit, int loja, String status) {
        this.placa = placa;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.loja = loja;
        this.status = status;
    }
    
    public boolean validarQuantidade() {
        return true;
    }
    
    public boolean validarPrecoUnit() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s <br/> Nome: %s <br/> Quantidade: %d <br/> "
                + "Preço Unitário: %.2f <br/> Loja: %d <br/> Status: %s", 
                placa,nome,quantidade,precoUnit,loja,status);
    }
}
