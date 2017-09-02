/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas.damaceno
 */
public final class ConnectionUtils {

    private ConnectionUtils(){};
    
    
    private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String user = "AULAJAVA";
    private final static String pass = "AULAJAVA";
    
    public static Connection retornaConexao() throws SQLException{
    
        return DriverManager.getConnection(url, user, pass);
       
    }
    

}
