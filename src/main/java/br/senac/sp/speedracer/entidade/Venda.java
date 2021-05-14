/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author João Dantas
 */

@Getter
@Setter
public class Venda {
    
    private String placa;       
    private String cpfCli;    
    private double precoUnit;
    private int filial;
    private Date data;
    
    public Venda(String placa, String cpfCli, double precoUnit, int filial, Date data) {
        this.placa = placa;
        this.cpfCli = cpfCli;
        this.precoUnit = precoUnit;
        this.filial = filial;
        this.data = data;
    }
    
    public boolean validarQuantidade() {
        return true;
    }
    
    public boolean validarPrecoUnit() {
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("Placa: %s <br/> CPF Cliente: %s <br/> Preço Unitário: %.2f <br/> Filial: %d", 
                placa, cpfCli, precoUnit, filial);
    }
}
