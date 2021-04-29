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
 * @author Vinicius Hilário
 */

@Getter
@Setter
public class Cliente {
    
    private String nome;
    private String email;
    private String cpf;
    private String endereco;
    private String cidade;
    private char sexo;
    private int ativo;

    public Cliente(String nome, String email, String cpf, String endereco, String cidade, char sexo, int ativo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.sexo = sexo;
        this.ativo = ativo;
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s <br/> Email: %s <br/> CPF: %s <br/> Endereço: %s "
                + "<br/> Cidade: %s <br/> Sexo: %c <br/> Ativo: %d", 
                nome,email,cpf,endereco,cidade,sexo,ativo);
    }
}
