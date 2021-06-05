/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.RelatorioAnalitico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saulo.ambezerra
 */
public class RelatorioAnaliticoDAO {
    
    public static List<RelatorioAnalitico> relatorioPorFilial(String filial, Date dataInicial, Date dataFinal){
        List<RelatorioAnalitico> relatorios = new ArrayList<>();
        String query = "SELECT * FROM VENDAS WHERE filial = ? AND data BETWEEN ? AND ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.valueOf(filial));
            ps.setDate(2, dataInicial);
            ps.setDate(3, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String produto = String.valueOf("produto");
                String cpfCli = rs.getString("cpfcli");
                Double precoUnit = rs.getDouble("precounit");
                int filial1 = rs.getInt("filial");
                Date data = rs.getDate("data");
                RelatorioAnalitico relatorio = new RelatorioAnalitico(produto, cpfCli, precoUnit, filial1, data);
                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
    
    public static List<RelatorioAnalitico> relatorioPorProduto(String produto, Date dataInicial, Date dataFinal){
        List<RelatorioAnalitico> relatorios = new ArrayList<>();
        String query = "SELECT * FROM VENDAS WHERE filial = ? AND data BETWEEN ? AND ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto);
            ps.setDate(2, dataInicial);
            ps.setDate(3, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String produto1 = String.valueOf("produto");
                String cpfCli = rs.getString("cpfcli");
                Double precoUnit = rs.getDouble("precounit");
                int filial1 = rs.getInt("filial");
                Date data = rs.getDate("data");
                RelatorioAnalitico relatorio = new RelatorioAnalitico(produto1, cpfCli, precoUnit, filial1, data);
                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
    
    public static List<RelatorioAnalitico> relatorioPorCliente(String cliente, Date dataInicial, Date dataFinal){
        List<RelatorioAnalitico> relatorios = new ArrayList<>();
        String query = "SELECT * FROM VENDAS WHERE cpfcli = ? AND data BETWEEN ? AND ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente);
            ps.setDate(2, dataInicial);
            ps.setDate(3, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String produto = String.valueOf("produto");
                String cpfCli = rs.getString("cpfcli");
                Double precoUnit = rs.getDouble("precounit");
                int filial1 = rs.getInt("filial");
                Date data = rs.getDate("data");
                RelatorioAnalitico relatorio = new RelatorioAnalitico(produto, cpfCli, precoUnit, filial1, data);
                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
}
