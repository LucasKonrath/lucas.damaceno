/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import java.sql.*;

/**
 *
 * @author lucas.damaceno
 */
public class Select {

    public static void main(String[] args) {

        // Oracle Thin 
// jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
// oracle.jdbc.driver.OracleDriver
        TesteDAO testando = new TesteDAO();
        
        testando.insert();
         
    }
}




