/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.Vendas;
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
 * @author Eduardo Silva
 */

public class VendasDAO {
    
    public static boolean cadastrar(Vendas vendas){
        boolean ok = true;
        String query = "insert into vendas (codprod, codcliente, produto,quantidade,valortotal) values (?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, vendas.getcodprod());
            ps.setInt(2, vendas.getcodcliente());
            ps.setDouble(3, vendas.getproduto());
            ps.setDouble(4, vendas.getquantidade());
            ps.setDouble(4, vendas.getvalortotal());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false; 
        }
        return ok;        
    } 
    
   public static List<Vendas> getVendas() {
        List<Vendas> produtos = new ArrayList<>();
        String query = "select * from vendas";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int codprod = rs.getInt("codprod");
                int codcliente = rs.getInt("codcliente");
                String produto  = rs.getString("produto");
                int quantidade  = rs.getInt("quantidade");
                int valortotal  = rs.getInt("valortotal");
                Vendas vendas = new Vendas(codprod, codcliente, produto,quantidade,valortotal);
                vendas.add(vendas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
}
