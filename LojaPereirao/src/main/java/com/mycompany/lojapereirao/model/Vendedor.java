package com.mycompany.lojapereirao.model;

//nome do projeto
public class Vendedor {
    
//Atributos
    
    private static int codVendedor;
    private String nome;
    private int cpf;
    private int loja;
    private String usuario;
    private String senha;
    
    
//Construtor
public Vendedor() {
    
}    

//Metodos acessores

    public static int getCodVendedor() {
        return codVendedor;
    }

    public static void setCodVendedor(int codVendedor) {
        Vendedor.codVendedor = codVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getLoja() {
        return loja;
    }

    public void setLoja(int loja) {
        this.loja = loja;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
