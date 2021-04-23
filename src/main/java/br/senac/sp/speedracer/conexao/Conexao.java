/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.senac.sp.speedracer.conexao.Conexao;
import br.senac.sp.speedracer.entidade.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Danta
 */
public class Conexao {
    
    static{
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddeDriver");
                    
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    public static Connection getConexao() throws SQLException{
        String url = "jdbc:derby://localhost:1527/SpeedRacer";
        String user = "";
        String pass = "";
        
        return DriverManager.getConnection(url,user,pass);
    }
    

    
}
