/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
  
    public Connection getConexao() throws SQLException{
        String url = "jbdc:derby://localhost:1527/senac";
        String user = "senac";
        String pass = "senac";
        
        return DriverManager.getConnection(url,user,pass);
    }
    
}
