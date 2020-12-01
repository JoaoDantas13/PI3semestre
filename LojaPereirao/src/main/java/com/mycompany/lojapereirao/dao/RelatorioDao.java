/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojapereirao.dao;

import com.mycompany.lojapereirao.model.Relatorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class RelatorioDao {

    public static ArrayList<Relatorio> Listar(String dataI, String dataF) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Relatorio> listaRelatorios = new ArrayList<>();
        ResultSet rs = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT cpf, sum(valorTotal) AS 'Total' FROM venda "
                            + "WHERE DATE (dataVenda) > ? AND DATE (dataVenda) < ? "
                            + "GROUP BY cpf ORDER BY cpf");

            instrucaoSQL.setString(1, dataI);
            instrucaoSQL.setString(2, dataF);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Relatorio rel = new Relatorio();
                rel.setCpfCli(rs.getLong("cpf"));
                rel.setTotal(rs.getDouble("total"));


                listaRelatorios.add(rel);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaRelatorios = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();

                    if (conexao != null) {
                        conexao.close();
                    }
                }
            } catch (SQLException ex) {
            }
        }
        return listaRelatorios;
    }

}
