package com.mycompany.lojapereirao.dao;

import com.mycompany.lojapereirao.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDao {

    public static boolean Salvar(Produto pProduto) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "INSERT INTO produto (nome, qtdCaixa, undMedida, saldo, valor) VALUES( ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            //Caso queira retornar o ID
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, pProduto.getNome());
            instrucaoSQL.setInt(2, pProduto.getQtdCaixa());
            instrucaoSQL.setString(3, pProduto.getUndMedida());
            instrucaoSQL.setInt(4, pProduto.getSaldo());
            instrucaoSQL.setDouble(5, pProduto.getValor());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
//                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente

//                if (generatedKeys.next()) {
//                    pProduto.setCodProd(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Falha ao obter o Código do Produto!.");
//                }
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

    public static boolean Alterar(Produto pProduto) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "UPDATE produto SET nome = ?, qtdCaixa = ?, undMedida = ?, saldo = ?, valor = ? WHERE codprod = ?",
                    Statement.RETURN_GENERATED_KEYS);

            //Caso queira retornar o ID
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, pProduto.getNome());
            instrucaoSQL.setInt(2, pProduto.getQtdCaixa());
            instrucaoSQL.setString(3, pProduto.getUndMedida());
            instrucaoSQL.setInt(4, pProduto.getSaldo());
            instrucaoSQL.setDouble(5, pProduto.getValor());
            instrucaoSQL.setDouble(6, pProduto.getCodProd());
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

    public static ArrayList<Produto> Listar() {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ResultSet rs = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM produto;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setCodProd(rs.getInt("codprod"));
                prod.setNome(rs.getString("nome"));
                prod.setQtdCaixa(rs.getInt("qtdCaixa"));
                prod.setUndMedida(rs.getString("undMedida"));
                prod.setSaldo(rs.getInt("saldo"));
                prod.setValor(rs.getDouble("valor"));

                listaProdutos.add(prod);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
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
        return listaProdutos;
    }

    public static ArrayList<Produto> Listar(int codprod) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
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
                Produto prod = new Produto();
                prod.setCodProd(rs.getInt("codprod"));
                prod.setNome(rs.getString("nome"));
                prod.setQtdCaixa(rs.getInt("qtdCaixa"));
                prod.setUndMedida(rs.getString("undMedida"));
                prod.setSaldo(rs.getInt("saldo"));
                prod.setValor(rs.getDouble("valor"));

                listaProdutos.add(prod);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
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
        return listaProdutos;
    }

    public static Produto consultarPorID(int codprod) {

        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
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
                retorno.setCodProd(rs.getInt("codprod"));
                retorno.setNome(rs.getString("nome"));
                retorno.setQtdCaixa(rs.getInt("qtdCaixa"));
                retorno.setUndMedida(rs.getString("undMedida"));
                retorno.setSaldo(rs.getInt("saldo"));
                retorno.setValor(rs.getDouble("valor"));

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

    public static boolean Excluir(int codprod) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3307/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "DELETE FROM produto WHERE codprod = ?");

            instrucaoSQL.setInt(1, codprod);
            
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
}
