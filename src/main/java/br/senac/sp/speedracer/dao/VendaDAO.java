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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Dantas
 */
public class VendaDAO {

    public static boolean cadastrar(Venda venda, Date data) {

        boolean ok = true;
        String query = "insert into Vendas (placa, cpfCli, precoUnit, filial, data, modelo) "
                + "values(?, ?, ?, ?, ?, ?)";
        Connection con;
        String modelo = buscarModelo(venda.getPlaca());

        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, venda.getPlaca());
            ps.setString(2, venda.getCpfCli());
            ps.setDouble(3, venda.getPrecoUnit());
            ps.setInt(4, venda.getFilial());
            ps.setDate(5, data);
            ps.setString(6, modelo);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }

        return ok;
    }

    public static List<Venda> vendasTodasLojas(Date dataFinal, Date dataInicial, String ordenacao) {
        List<Venda> vendas = new ArrayList<>();
        String query = "select * from Vendas where data betwen ? and ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String placa = rs.getString("placa");
                String cpf = rs.getString("cpf");
                Double precoUnit = rs.getDouble("precoUnit");
                int filial = rs.getInt("filial");
                Date data = rs.getDate("data");
                Venda venda = new Venda(placa, cpf, precoUnit, filial, data);
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static String buscarModelo(String placa) {
        String modelo = null;
        String query = "SELECT modelo FROM produto WHERE placa=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                modelo = rs.getString("modelo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
}
