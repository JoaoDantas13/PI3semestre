/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.Produto;
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

public class ProdutoDAO {
    
    public static boolean cadastrar(Produto produto){
        boolean ok = true;
        String query = "insert into produto (placa, nome, quantidade, precoUnit, loja, status) values (?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getPlaca());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getPrecoUnit());
            ps.setInt(5, produto.getLoja());
            ps.setString(6, produto.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;        
    } 
    
   public static List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String placa = rs.getString("placa");
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                double precoUnit  = rs.getDouble("precoUnit");
                int loja = rs.getInt("loja");
                String status = rs.getString("status");
                
                Produto produto = new Produto(placa, nome, quantidade, precoUnit, loja, status);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
 
   public static Produto getProduto(String placa) {
        Produto produto = null;
        String query = "select * from produto where placa=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                double precoUnit = rs.getDouble("precoUnit");
                int loja = rs.getInt("loja");
                String status = rs.getString("status");
                produto = new Produto(placa, nome, quantidade, precoUnit, loja, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }   
   
   public static boolean inativar(String placa) {
        boolean ok = true;
        String query = "update produto set status='Inativo' where placa=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, placa);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }   
   
   public static boolean atualizar(Produto produto) {
        boolean ok = true;
        String query = "update produto set nome=?, quantidade=?, precoUnit=?, loja=?, status=?"
                + " where placa=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPrecoUnit());
            ps.setInt(4, produto.getLoja());
            ps.setString(5, produto.getStatus());
            ps.setString(6, produto.getPlaca());           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }      
      
}
