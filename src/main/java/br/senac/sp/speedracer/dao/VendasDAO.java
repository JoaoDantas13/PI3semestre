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




public class VendasDAO {
    
        public static List<Vendas> getVendas() {
               
        List<Vendas> vendas = new ArrayList<>();
        String query = "select * from Vendas";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String PLACA = rs.getString("PLACA");
                String NOME = rs.getString("NOME");
                int QUANTIDADE = rs.getInt("QUANTIDADE");
                double PRECOUNIT = rs.getDouble("PRECOUNIT");
                /*Vendas vendas = new Vendas(PLACA, NOME, QUANTIDADE, PRECOUNIT);*/
                /*vendas.add(vendas);*/
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;

    }
    
    public static boolean cadastrar(Vendas vendas){
        boolean ok = true;
        String query = "insert into Vendas (placa, nome,quantidade,precounit) values (?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, vendas.getPLACA());
            ps.setString(2, vendas.getNOME());
            ps.setInt(3, vendas.getQUANTIDADE());
            ps.setDouble(4, vendas.getPRECOUNIT());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false; 
        }
        return ok;        
    } 

    

    
}

