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
 * @author João Dantas
 */

@Getter
@Setter
public class Venda {
    
    private String placa;
    private String marca;
    private String nome;
    private String cpfCli;
    private int quantidade;
    private double precoUnit;
    private int filial;

    public Venda(String placa, String marca, String nome, String cpfCli, int quantidade, double precoUnit, int filial) {
        this.placa = placa;
        this.marca = marca;
        this.nome = nome;
        this.cpfCli = cpfCli;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.filial = filial;
    }
    
    public boolean validarQuantidade() {
        return true;
    }
    
    public boolean validarPrecoUnit() {
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("Placa: %s <br/> Marca: %s <br/> Nome: %s <br/> CPF Cliente: %s <br/> "
                + "Quantidade: %d <br/> Preço Unitário: %.2f <br/> Filial: %d", 
                placa, marca, nome, cpfCli, quantidade, precoUnit, filial);
    }
}
