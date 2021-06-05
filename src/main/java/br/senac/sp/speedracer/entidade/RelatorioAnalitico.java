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
 * @author saulo.ambezerra
 */

@Getter
@Setter
public class RelatorioAnalitico {
    private String produto;       
    private String cpfCli;    
    private double precoUnit;
    private int filial;
    private Date data;

    public RelatorioAnalitico(String produto, String cpfCli, double precoUnit, int filial, Date data) {
        this.produto = produto;
        this.cpfCli = cpfCli;
        this.precoUnit = precoUnit;
        this.filial = filial;
        this.data = data;
    }
    
    
}