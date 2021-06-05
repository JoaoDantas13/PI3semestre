/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.dao;

import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.RelatorioSintetico;
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
public class RelatorioSinteticoDAO {

    public static List<RelatorioSintetico> relatorioPorModelo(Date dataInicial, Date dataFinal) {
        List<RelatorioSintetico> relatorios = new ArrayList<>();
        String query = "SELECT SUM(precounit) AS valortotal, COUNT(modelo) AS quantidadetotal, modelo FROM vendas WHERE data BETWEEN ? AND ?  GROUP BY modelo";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String buscaPor = rs.getString("modelo");
                int quantidade = rs.getInt("quantidadetotal");
                Double total = rs.getDouble("valortotal");
                RelatorioSintetico relatorio = new RelatorioSintetico(buscaPor, quantidade, total);
                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
    
    public static List<RelatorioSintetico> relatorioCliente(Date dataInicial, Date dataFinal) {
        List<RelatorioSintetico> relatorios = new ArrayList<>();
        String query = "SELECT SUM(precounit) AS valortotal, COUNT(cpfcli) AS quantidadetotal, cpfcli FROM vendas WHERE data BETWEEN ? AND ? GROUP BY cpfcli";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String buscaPor = rs.getString("cpfcli");
                int quantidade = rs.getInt("quantidadetotal");
                Double total = rs.getDouble("valortotal");
                RelatorioSintetico relatorio = new RelatorioSintetico(buscaPor, quantidade, total);
                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
    
    public static List<RelatorioSintetico> relatorioPorFilial(Date dataInicial, Date dataFinal) {
        List<RelatorioSintetico> relatorios = new ArrayList<>();
        String query = "SELECT SUM(precounit) AS valortotal, COUNT(filial) AS quantidadetotal, filial FROM vendas WHERE data BETWEEN ? AND ? GROUP BY filial";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String buscaPor = String.valueOf(rs.getInt("filial"));
                int quantidade = rs.getInt("quantidadetotal");
                Double total = rs.getDouble("valortotal");
                RelatorioSintetico relatorio = new RelatorioSintetico(buscaPor, quantidade, total);
                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorios;
    }
}
