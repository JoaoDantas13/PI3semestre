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
 * @author saulo.ambezerra
 */
@Getter
@Setter
public class RelatorioSintetico {
    private String nome;
    private int quantidade;
    private Double total;

    public RelatorioSintetico(String nome, int quantidade, Double total) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.total = total;
    }
}
