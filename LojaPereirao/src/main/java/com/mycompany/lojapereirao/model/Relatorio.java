/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojapereirao.model;

/**
 *
 * @author Vimicius
 */
public class Relatorio {
    
    private long cpfCli;
    private String dataI;
    private String dataF;
    private double total;
    private double totalGeral;
    
    public Relatorio(){
    
    }

    public long getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(long cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getDataI() {
        return dataI;
    }

    public void setDataI(String dataI) {
        this.dataI = dataI;
    }

    public String getDataF() {
        return dataF;
    }

    public void setDataF(String dataF) {
        this.dataF = dataF;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(double totalGeral) {
        this.totalGeral = totalGeral;
    }
    
    
    
}
