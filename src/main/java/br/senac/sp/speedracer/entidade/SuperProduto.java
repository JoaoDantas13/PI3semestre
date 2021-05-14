/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SuperProduto {

    private final String placa;
    private int quantidade;
    private double precoUnit;

    public SuperProduto(String placa, int quantidade, double precoUnit){
        this.placa = placa;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;  
    }

    @Override
    public String toString() {
        return String.format("Placa: %s <br/>"
                + "Quantidade: %d <br/> "
                + "Preço Unitário: %.2f", 
                placa,quantidade,precoUnit);
    }    
    
}
