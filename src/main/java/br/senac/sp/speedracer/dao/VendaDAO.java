/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Dantas
 */
public class VendaDAO {
    
     public static boolean cadastrar(Venda venda){
         
         boolean ok = true;
         String query = "insert into Vendas (placa, marca, nome, cpfCli, quantidade, precoUnit, filial) values(?, ?, ?, ?, ?, ?, ?)";
         Connection con;
         
         try {
             con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, venda.getPlaca());
             ps.setString(2, venda.getMarca());
             ps.setString(3, venda.getNome());
             ps.setString(4, venda.getCpfCli());
             ps.setInt(5, venda.getQuantidade());
             ps.setDouble(6, venda.getPrecoUnit());
             ps.setInt(7, venda.getFilial());
             ps.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
            
            return ok;
        }
}
