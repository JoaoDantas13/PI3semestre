package com.mycompany.lojapereirao.dao;

import com.mycompany.lojapereirao.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDao {

    public static boolean Salvar(Produto pProduto) {

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
        }
    

        finally{
        //Libero os recursos da memória
        try {
            if (instrucaoSQL != null) {
                instrucaoSQL.close();
            }
            conexao.close();
        } catch (SQLException ex) {
        }
    }
    return retorno ;

}
}
