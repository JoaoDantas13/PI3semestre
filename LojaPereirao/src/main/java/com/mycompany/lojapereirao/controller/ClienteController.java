
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
    
    public static boolean Alterar(String nome, long cpf, char sexo, String dataNasc, String logradouro, String cidade, String uf, int cep, int telefone, long celular, String email,int codcli){
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
        obj.setCodCli(codcli);
                
        return ClienteDao.Alterar(obj);
    }
    
    public static boolean Excluir(int codCli){
            
            return ClienteDao.Excluir(codCli);
        }
    
    public static ArrayList<String []> Listar(){
        
        ArrayList<Cliente> listaClientes = ClienteDao.Listar();
        
        ArrayList<String []> listaRetorno = new ArrayList<>();
        
        for(Cliente cli : listaClientes){
            listaRetorno.add(new String[]{String.valueOf(cli.getCodCli()) 
                                        ,String.valueOf(cli.getNome())
                                        ,String.valueOf(cli.getCpf())
                                        ,String.valueOf(cli.getSexo())
                                        ,String.valueOf(cli.getDataNasc())
                                
            });
        }    
        
        return listaRetorno;
    }
    
    public static ArrayList<String []> Listar(long cpf){
        
        ArrayList<Cliente> listaClientes = ClienteDao.Listar(cpf);
        
        ArrayList<String []> listaRetorno = new ArrayList<>();
        
        for(Cliente cli : listaClientes){
            listaRetorno.add(new String[]{String.valueOf(cli.getCodCli()) 
                                        ,String.valueOf(cli.getNome())
                                        ,String.valueOf(cli.getCpf())
                                        ,String.valueOf(cli.getSexo())
                                        ,String.valueOf(cli.getDataNasc())
                                
            });
        }    
        
        return listaRetorno;
    }
    
    public static ArrayList<String []> Listar(String nome){
        
        ArrayList<Cliente> listaClientes = ClienteDao.Listar(nome);
        
        ArrayList<String []> listaRetorno = new ArrayList<>();
        
        for(Cliente cli : listaClientes){
            listaRetorno.add(new String[]{String.valueOf(cli.getCodCli()) 
                                        ,String.valueOf(cli.getNome())
                                        ,String.valueOf(cli.getCpf())
                                        ,String.valueOf(cli.getSexo())
                                        ,String.valueOf(cli.getDataNasc())
                                
            });
        }    
        
        return listaRetorno;
    }
    
    public static String[] consultarPorID(int codcli){
            
           Cliente objRetorno = ClienteDao.consultarPorID(codcli);
           String[] retorno = null;
           
            if (objRetorno != null) {
                
                retorno = new String[]{String.valueOf (objRetorno.getCodCli())
                                       ,String.valueOf(objRetorno.getNome())
                                       ,String.valueOf(objRetorno.getCpf())
                                       ,String.valueOf(objRetorno.getSexo())
                                       ,String.valueOf(objRetorno.getDataNasc())
                                       ,String.valueOf(objRetorno.getLogradouro())
                                       ,String.valueOf(objRetorno.getCidade())
                                       ,String.valueOf(objRetorno.getUf())
                                       ,String.valueOf(objRetorno.getCep())
                                       ,String.valueOf(objRetorno.getTelefone())
                                       ,String.valueOf(objRetorno.getCelular())
                                       ,String.valueOf(objRetorno.getEmail())
                };
            }
            
            return retorno;
        }
}
