
package com.mycompany.lojapereirao.dao;

import com.mycompany.lojapereirao.model.Cliente;
import com.mycompany.lojapereirao.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ClienteDao {

       public static boolean Salvar(Cliente pCliente) {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3306/lojapereirao?useTimezone=true&serverTimezone=UTC";
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
                    "INSERT INTO cliente (nome, cpf, sexo, dataNasc, logradouro, cidade, uf, cep, telefone, celular, email) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            //Caso queira retornar o ID
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, pCliente.getNome());
            instrucaoSQL.setLong(2, pCliente.getCpf());
            instrucaoSQL.setString(3, String.valueOf((pCliente.getSexo())));
            instrucaoSQL.setString(4, pCliente.getDataNasc());
            instrucaoSQL.setString(5, pCliente.getLogradouro());
            instrucaoSQL.setString(6, pCliente.getCidade());
            instrucaoSQL.setString(7, pCliente.getUf());
            instrucaoSQL.setInt(8, pCliente.getCep());
            instrucaoSQL.setInt(9, pCliente.getTelefone());
            instrucaoSQL.setLong(10, pCliente.getCelular());
            instrucaoSQL.setString(11, pCliente.getEmail());
            
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
       
       
    public static ArrayList<Cliente> Listar() {

        boolean retorno = false;
        String nomeBaseDados = "lojapereirao";
        String URL = "jdbc:mysql://localhost:3306/lojapereirao?useTimezone=true&serverTimezone=UTC";
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ResultSet rs = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir Conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM cliente;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCodCli(rs.getInt("codcli"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getLong("cpf"));
      //          cli.setSexo(rs.getString("sexo"));
                cli.setDataNasc(rs.getString("dataNasc"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUf(rs.getString("uf"));
                cli.setTelefone(rs.getInt("telefone"));
                cli.setCelular(rs.getLong("logradouro"));
                cli.setEmail(rs.getString("email"));

                listaClientes.add(cli);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        return listaClientes;
    }       
    
}
