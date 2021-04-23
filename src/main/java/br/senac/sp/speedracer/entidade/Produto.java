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
    private String nome;
    private int quantidade;
    private double precoUnit;
    
    public Produto(String nome, int quantidade, double precoUnit) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
    }
    
    public boolean validarQuantidade() {
        return true;
    }
    
    public boolean validarPrecoUnit() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s <br/> Quantidade: %d <br/> Preço Unitário: %.2f", 
                nome, quantidade , precoUnit);
    }
}
