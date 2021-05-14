/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Hilario
 */
public class ClienteDAO {
    
    public static List<Cliente> getClientes() {
               
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from Cliente where ativo = 0";
        Connection con;
        
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                char sexo = rs.getString("sexo").charAt(0);
                int ativo = rs.getInt("ativo");
                int loja = rs.getInt("loja");
                
                Cliente cliente = new Cliente(nome,email,cpf,endereco,cidade,sexo,ativo,loja);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }
    
    public static boolean cadastrar (Cliente cliente){
        
        boolean ok = true;
        String query = "insert into Cliente (nome, email, cpf, endereco, cidade, sexo, ativo, loja) "
                + "values(?, ?, ?, ?, ?, ?, 0, ?)";
        Connection con;
        
        try {
            
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getCidade());
            ps.setString(6, String.valueOf(cliente.getSexo()));
            ps.setInt(7, cliente.getLoja());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
               
        return ok;
    }
    
    public static Cliente dadosAlterar (String cpf) {
        
        Cliente cliente = null;
        String query = "select * from Cliente where cpf = ?";
        Connection con;
        
        try {
            
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                char sexo = rs.getString("sexo").charAt(0);
                int ativo = rs.getInt("ativo");
                int loja = rs.getInt("loja");
                                
                cliente = new Cliente(nome,email,cpf,endereco,cidade,sexo,ativo,loja);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }
    
    public static boolean alterar(Cliente cliente){
        
        boolean ok = true;
        String query = "update Cliente set nome=?, email=?, endereco=?, cidade=?, sexo=?, loja=? where cpf = ?";
        Connection con;
        
        try {
            
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(7, cliente.getCpf());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, String.valueOf(cliente.getSexo()));
            ps.setInt(6, cliente.getLoja());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
               
        return ok;
    }
    
    public static boolean Inativar(String cpf){
        
        boolean ok = true;
        String query = "update Cliente set ativo = 1 where cpf = ?";
        Connection con;
        
        try {
            
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
            
        }
        
        return ok;
    }
    
    public static boolean Ativar(String cpf){
        
        boolean ok = true;
        String query = "update Cliente set ativo = 0 where cpf = ?";
        Connection con;
        
        try {
            
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
            
        }
        
        return ok;
    }
    
    public static List<Cliente> getClientesInativos() {
               
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from Cliente where ativo = 1";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                char sexo = rs.getString("sexo").charAt(0);
                int ativo = rs.getInt("ativo");
                int loja = rs.getInt("loja");
                
                Cliente cliente = new Cliente(nome,email,cpf,endereco,cidade,sexo,ativo,loja);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return clientes;
    }
}
