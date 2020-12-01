package com.mycompany.lojapereirao.dao;

import com.mycompany.lojapereirao.model.Cliente;
import com.mycompany.lojapereirao.model.Produto;
import com.mycompany.lojapereirao.model.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDao {

    public static boolean ValidarCpf(long cpf) {
        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3306/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;
        ArrayList<Venda> listaVendas = new ArrayList<>();

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "UPDATE cliente SET cpf = ? WHERE cpf = ?");

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setLong(1, cpf);
            instrucaoSQL.setLong(2, cpf);

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                conexao.close();
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }

    public static Produto ValidarSaldo(int codprod) {

        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3306/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Produto retorno = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE codprod = ?");
            instrucaoSQL.setInt(1, codprod);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                retorno = new Produto();
                retorno.setSaldo(rs.getInt("saldo"));

            }
        } catch (Exception e) {

            retorno = null;

        } finally {

            if (instrucaoSQL != null) {

                try {
                    instrucaoSQL.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {

                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return retorno;
    }

    public static Cliente consultaCodCli(long cpf) {

        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3306/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Cliente retorno = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
            instrucaoSQL.setLong(1, cpf);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                retorno = new Cliente();
                retorno.setCodCli(rs.getInt("codcli"));

            }
        } catch (Exception e) {

            retorno = null;

        } finally {

            if (instrucaoSQL != null) {

                try {
                    instrucaoSQL.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {

                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return retorno;
    }

    public static ArrayList<Venda> Listar(int codprod, int qtd) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3306/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Venda> listaVendas = new ArrayList<>();
        ResultSet rs = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM produto WHERE codprod = ?");

            instrucaoSQL.setInt(1, codprod);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Venda vend = new Venda();
                vend.setCodProd(rs.getInt("codprod"));
                vend.setValorUnt(rs.getDouble("valor"));

                listaVendas.add(vend);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVendas = null;
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
        return listaVendas;
    }
}
