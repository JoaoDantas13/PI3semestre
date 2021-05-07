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
    private String  PLACA;
    private String NOME;
    private int QUANTIDADE;
    private Double PRECOUNIT;
    
    public Vendas(String PLACA, String NOME, int QUANTIDADE , double PRECOUNIT) {
        this.PLACA = PLACA;
        this.NOME = NOME;
        this.QUANTIDADE = QUANTIDADE;
        this.PRECOUNIT = PRECOUNIT;
    }
    
    @Override
    public String toString(){
        return String.format("PLACA: %s <br/> NOME: %s <br/> QUANTIDADE: %d  <br/> "
                + "           PRECOUNIT %.2f</br>", 
                PLACA, NOME , QUANTIDADE ,PRECOUNIT);
    }

    
}
