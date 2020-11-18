package com.mycompany.lojapereirao.controller;

import com.mycompany.lojapereirao.dao.ProdutoDao;
import com.mycompany.lojapereirao.model.Produto;


public class ProdutoController {
    
    public static boolean Salvar(String nomeProduto, int qtdCaixa, String undMedida, int saldo, double valor){
        Produto obj = new Produto();
        obj.setNome(nomeProduto);
        obj.setQtdCaixa(qtdCaixa);
        obj.setUndMedida(undMedida);
        obj.setSaldo(saldo);
        obj.setValor(valor);
        
        return ProdutoDao.Salvar(obj);
    }
}
