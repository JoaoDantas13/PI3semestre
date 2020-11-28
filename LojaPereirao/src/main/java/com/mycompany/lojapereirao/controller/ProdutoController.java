package com.mycompany.lojapereirao.controller;

import com.mycompany.lojapereirao.dao.ProdutoDao;
import com.mycompany.lojapereirao.model.Produto;
import java.util.ArrayList;


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
    
        public static boolean Alterar(String nomeProduto, int qtdCaixa, String undMedida, int saldo, double valor, int codprod){
        Produto obj = new Produto();
        obj.setNome(nomeProduto);
        obj.setQtdCaixa(qtdCaixa);
        obj.setUndMedida(undMedida);
        obj.setSaldo(saldo);
        obj.setValor(valor);
        obj.setCodProd(codprod);
        
        return ProdutoDao.Alterar(obj);
    }
        
    public static ArrayList<String []> Listar(){
        
        ArrayList<Produto> listaProdutos = ProdutoDao.Listar();
        
        ArrayList<String []> listaRetorno = new ArrayList<>();
        
        for(Produto prod : listaProdutos){
            listaRetorno.add(new String[]{String.valueOf(prod.getCodProd()) 
                                        ,String.valueOf(prod.getNome())
                                        ,String.valueOf(prod.getQtdCaixa())
                                        ,String.valueOf(prod.getUndMedida())
                                        ,String.valueOf(prod.getSaldo())
                                        ,String.valueOf(prod.getValor())
            });
        }    
        
        return listaRetorno;
    }
    
        public static ArrayList<String []> Listar(int codprod){
        
        ArrayList<Produto> listaProdutos = ProdutoDao.Listar(codprod);
        
        ArrayList<String []> listaRetorno = new ArrayList<>();
        
        for(Produto prod : listaProdutos){
            listaRetorno.add(new String[]{String.valueOf(prod.getCodProd()) 
                                        ,String.valueOf(prod.getNome())
                                        ,String.valueOf(prod.getQtdCaixa())
                                        ,String.valueOf(prod.getUndMedida())
                                        ,String.valueOf(prod.getSaldo())
                                        ,String.valueOf(prod.getValor())
            });
        }    
        
        return listaRetorno;
    }
        
        public static String[] consultarPorID(int codprod){
            
           Produto objRetorno = ProdutoDao.consultarPorID(codprod);
           String[] retorno = null;
           
            if (objRetorno != null) {
                
                retorno = new String[]{String.valueOf (objRetorno.getCodProd())
                                       ,String.valueOf(objRetorno.getNome())
                                       ,String.valueOf(objRetorno.getQtdCaixa())
                                       ,String.valueOf(objRetorno.getUndMedida())
                                       ,String.valueOf(objRetorno.getSaldo())
                                       ,String.valueOf(objRetorno.getValor())
                };
            }
            
            return retorno;
        }
}
