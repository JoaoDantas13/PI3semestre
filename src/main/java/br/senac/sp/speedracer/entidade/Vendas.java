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
    private int  CPF;
    private String Produto;
    private int Quantidade;
    
}
