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
                Cliente cliente = new Cliente(nome,email,cpf,endereco,cidade,sexo,ativo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }
    
    
    
}
