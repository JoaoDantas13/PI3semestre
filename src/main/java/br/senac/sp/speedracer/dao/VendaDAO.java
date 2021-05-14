/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Dantas
 */
public class VendaDAO {
    
     public static boolean cadastrar(Venda venda, Date data){
         
         boolean ok = true;
         String query = "insert into Vendas (placa, cpfCli, precoUnit, filial, data) "
                 + "values(?, ?, ?, ?, ?)";
         Connection con;
         
         try {
             con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, venda.getPlaca());
             ps.setString(2, venda.getCpfCli());
             ps.setDouble(3, venda.getPrecoUnit());
             ps.setInt(4, venda.getFilial());
             ps.setDate(5, data);
             
             ps.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
             ok = false;
         }
            
            return ok;
        }
}
