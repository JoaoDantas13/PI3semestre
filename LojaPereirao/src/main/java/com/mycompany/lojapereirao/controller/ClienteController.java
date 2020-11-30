
package com.mycompany.lojapereirao.controller;

import com.mycompany.lojapereirao.dao.ClienteDao;
import com.mycompany.lojapereirao.model.Cliente;
import java.util.ArrayList;



public class ClienteController {
    
    public static boolean Salvar(String nome, long cpf, char sexo, String dataNasc, String logradouro, String cidade, String uf, int cep, int telefone, long celular, String email){
        Cliente obj = new Cliente();
        obj.setNome(nome);
        obj.setCpf(cpf);
        obj.setSexo(sexo);
        obj.setDataNasc(dataNasc);
        obj.setLogradouro(logradouro);
        obj.setCidade(cidade);
        obj.setUf(uf);
        obj.setCep(cep);
        obj.setTelefone(telefone);
        obj.setCelular(celular);
        obj.setEmail(email);
        
        return ClienteDao.Salvar(obj);
    }
    
    public static ArrayList<String []> Listar(){
        
        ArrayList<Cliente> listaClientes = ClienteDao.Listar();
        
        ArrayList<String []> listaRetorno = new ArrayList<>();
        
        for(Cliente prod : listaClientes){
            listaRetorno.add(new String[]{String.valueOf(prod.getCodCli()) 
                                        ,String.valueOf(prod.getNome())
                                        ,String.valueOf(prod.getCpf())
                                        ,String.valueOf(prod.getSexo())
                                        ,String.valueOf(prod.getDataNasc())
                                        ,String.valueOf(prod.getLogradouro())
                                        ,String.valueOf(prod.getCidade())
                                        ,String.valueOf(prod.getUf())
                                        ,String.valueOf(prod.getTelefone())
                                        ,String.valueOf(prod.getCelular())
                                        ,String.valueOf(prod.getEmail())
            });
        }    
        
        return listaRetorno;
    }

    
}
