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

/**
 *
 * @author Danta
 */
public class Conexao {

    static {
        try {
           
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConexao() throws SQLException {
        
        String url = "jdbc:derby://localhost:1527/SpeeddRacer1";
        String user = "racer";
        String pass = "racer";

        return DriverManager.getConnection(url, user, pass);
    }

}
