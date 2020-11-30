
package com.mycompany.lojapereirao.controller;

import com.mycompany.lojapereirao.dao.ClienteDao;
import com.mycompany.lojapereirao.model.Cliente;



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

    
}
